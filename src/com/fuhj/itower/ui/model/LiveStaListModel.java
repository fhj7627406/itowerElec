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

import com.fuhj.itower.service.StationService;

/**
 * @Description: TODO
 * @author fu
 * @date 2016-3-20
 */
public class LiveStaListModel extends AbstractListModel<StationModel> {

	private static final long serialVersionUID = 5717816707924363661L;
	private StationService service;
	private StaQueryParam param;
	private int sumSize;
	private int pageSize = 10;
	private final static String CACHE_KEY = "StationModel_cache";

	public LiveStaListModel(StationService service, StaQueryParam param) {
		this.service = service;
		this.param = param;
		this.sumSize = service.getStaCount(param);
		getCache().clear();
	}

	public LiveStaListModel(StationService service, StaQueryParam param, int pageSize) {
		this(service, param);
		this.pageSize = pageSize;
	}

	/*
	 * (non-Javadoc)
	 * @see org.zkoss.zul.ListModel#getElementAt(int)
	 */
	@Override public StationModel getElementAt(int index) {
		Map<Integer, StationModel> cache = getCache();
		StationModel targetSta = cache.get(index);
		if (targetSta == null) {
			// if cache doesn't contain target object, query a
			// page size of data starting from the index
			List<StationModel> pageResult = service.getStations(param, index, pageSize);
			int indexKey = index;
			for (StationModel a : pageResult) {
				cache.put(indexKey, a);
				indexKey++;
			}
		} else {
			return targetSta;
		}
		// get the target after query from database
		targetSta = cache.get(index);
		if (targetSta == null) {
			// if we still cannot find the target object from
			// database, there is inconsistency between memory and the database
			throw new RuntimeException("Element at index" + index + " cannot be found in the database.");
		} else {
			return targetSta;
		}
	}

	private Map<Integer, StationModel> getCache() {
		Session session = Executions.getCurrent().getSession();
		// we only reuse this cache in one execution to avoid
		// accessing detached objects.
		// our filter opens a session during a HTTP request
		Map<Integer, StationModel> cache = (Map) session.getAttribute(CACHE_KEY);
		if (cache == null) {
			cache = new HashMap<Integer, StationModel>();
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
