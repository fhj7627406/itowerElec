CKEDITOR.editorConfig = function(config) {
	//config.height = 10000;
	// 图片上传配置
	
	
	//config.filebrowserUploadUrl = 'zkau/ckezupload/aa';
	//config.filebrowserImageUploadUrl = 'zkau/ckezupload?type=image&url=aaa&uuid=testckeditor';
	
	// 图片浏览配置
	//alert("测试4");
//	config.filebrowserImageBrowseUrl = 'browerServer.do?type=image';
	config.removeDialogTabs = 'image:advanced';
	config.language = 'zh-cn';
	config.skin = 'office2013';
	config.resize_enabled = false;
	config.image_previewText=  CKEDITOR.tools.repeat( ' ', 1 );
	//config.toolbar = 'Full';
	/*config.toolbar_Full =
		[
		    { name: 'document',    items : [ 'Source','-','Save','NewPage','DocProps','Preview','Print','-','Templates' ] },
		    { name: 'clipboard',   items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },
		    { name: 'editing',     items : [ 'Find','Replace','-','SelectAll','-','SpellChecker', 'Scayt' ] },
		    { name: 'forms',       items : [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField' ] },
		    '/',
		    { name: 'basicstyles', items : [ 'Bold','Italic','Underline','Strike','Subscript','Superscript','-','RemoveFormat' ] },
		    { name: 'paragraph',   items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote','CreateDiv','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','BidiLtr','BidiRtl' ] },
		    { name: 'links',       items : [ 'Link','Unlink','Anchor' ] },
		    { name: 'insert',      items : [ 'Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak' ] },
		    '/',
		    { name: 'styles',      items : [ 'Styles','Format','Font','FontSize' ] },
		    { name: 'colors',      items : [ 'TextColor','BGColor' ] },
		    { name: 'tools',       items : [ 'Maximize', 'ShowBlocks','-','About' ] }
		];*/
	config.font_names='宋体/宋体;黑体/黑体;隶书/隶书;幼圆/幼圆;微软雅黑/微软雅黑;'+ config.font_names;
	config.toolbar =
		[
		 { name: 'document',    items : [ 'Source','-','NewPage','DocProps','Preview','Print','-','Templates' ] },
		    { name: 'clipboard',   items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },
		    { name: 'editing',     items : [ 'Find','Replace','-','SelectAll','-','SpellChecker', 'Scayt' ] },
		    { name: 'forms',       items : [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField' ] },
		    '/',
		    { name: 'basicstyles', items : [ 'Bold','Italic','Underline','Strike','Subscript','Superscript','-','RemoveFormat' ] },
		    { name: 'paragraph',   items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote','CreateDiv','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','BidiLtr','BidiRtl' ] },
		    { name: 'links',       items : [ 'Link','Unlink','Anchor' ] },
		    { name: 'insert',      items : [ 'Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak' ] },
		    '/',
		    { name: 'styles',      items : [ 'Styles','Format','Font','FontSize' ] },
		    { name: 'colors',      items : [ 'TextColor','BGColor' ] },
		    { name: 'tools',       items : [ 'ShowBlocks','Maximize' ] }
		];
};