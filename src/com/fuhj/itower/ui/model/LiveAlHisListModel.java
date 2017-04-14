/**
 * 
 */
package com.fuhj.itower.ui.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zul.AbstractListModel;

import com.fuhj.itower.service.MainService;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-20
 */
public class LiveAlHisListModel extends AbstractListModel<AlarmHistoryModel> {

	private static final long serialVersionUID = -1278494699617249684L;
	private MainService service;
	private AlarmHisQueryParam param;
	private int sumSize;
	private int pageSize = 10;
	private final static String CACHE_KEY = "AlarmHistoryModel_cache";

	public LiveAlHisListModel(MainService service, AlarmHisQueryParam param) {
		this.service = service;
		this.param = param;
		this.sumSize = 2000;
		getCache().clear();
	}

	public LiveAlHisListModel(MainService service, AlarmHisQueryParam param, int pageSize) {
		this(service, param);
		this.pageSize = pageSize;
	}

	/*
	 * (non-Javadoc)
	 * @see org.zkoss.zul.ListModel#getElementAt(int)
	 */
	@Override public AlarmHistoryModel getElementAt(int index) {
		Map<Integer, AlarmHistoryModel> cache = getCache();
		AlarmHistoryModel targetAmh = cache.get(index);
		if (targetAmh == null) {
			// if cache doesn't contain target object, query a
			// page size of data starting from the index
			List<AlarmHistoryModel> pageResult = service.getAlarmHistorys(param, index, pageSize);
			int indexKey = index;
			for (AlarmHistoryModel a : pageResult) {
				cache.put(indexKey, a);
				indexKey++;
			}
		} else {
			return targetAmh;
		}
		// get the target after query from database
		targetAmh = cache.get(index);
		if (targetAmh == null) {
			// if we still cannot find the target object from
			// database, there is inconsistency between memory and the database
			throw new RuntimeException("Element at index" + index + " cannot be found in the database.");
		} else {
			return targetAmh;
		}
	}

	private Map<Integer, AlarmHistoryModel> getCache() {
		Session session = Executions.getCurrent().getSession();
		// we only reuse this cache in one execution to avoid
		// accessing detached objects.
		// our filter opens a session during a HTTP request
		Map<Integer, AlarmHistoryModel> cache = (Map) session.getAttribute(CACHE_KEY);
		if (cache == null) {
			cache = new HashMap<Integer, AlarmHistoryModel>();
			session.setAttribute(CACHE_KEY, cache);
		}
		return cache;
	}

	/*
	 * (non-Javadoc)
	 * @see org.zkoss.zul.ListModel#getSize()
	 */
	@Override public int getSize() {
		return this.sumSize;
	}
}
