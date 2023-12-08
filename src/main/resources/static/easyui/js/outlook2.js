/*
jQuery文档就绪事件处理器
它确保在HTML文档加载和解析完成后再执行其中的脚本
*/
$(function(){
	InitLeftMenu();
	tabClose();
	tabCloseEven();
})


/*
初始化左侧菜单
用于初始化页面左侧菜单
*/
function InitLeftMenu() {
	$("#nav").accordion({animate:false});

	// 遍历菜单数据，动态创建菜单项
	$.each(_menus.menus, function(i, n) {
		var menulist ='';
		menulist +='<ul>';
		$.each(n.menus, function(j, o) {
			menulist += '<li><div><a ref="'+o.menuid+'" href="#" rel="' + o.url + '" ><span class="icon '+o.icon+'" >&nbsp;</span><span class="nav">' + o.menuname + '</span></a></div></li> ';
		})
		menulist += '</ul>';

		// 将创建的菜单列表添加到手风琴组件中
		$('#nav').accordion('add', {
			title: n.menuname,
			content: menulist,
			iconCls: 'icon ' + n.icon
		});
	});

	// 绑定菜单项的点击事件，用于打开新的选项卡
	$('.easyui-accordion li a').click(function(){
		var tabTitle = $(this).children('.nav').text();

		var url = $(this).attr("rel");
		var menuid = $(this).attr("ref");
		var icon = getIcon(menuid,icon);

		addTab(tabTitle,url,icon);
		$('.easyui-accordion li div').removeClass("selected");
		$(this).parent().addClass("selected");
	}).hover(function(){
		$(this).parent().addClass("hover");
	},function(){
		$(this).parent().removeClass("hover");
	});

	// 选中第一个菜单项
	var panels = $('#nav').accordion('panels');
	var t = panels[0].panel('options').title;
	$('#nav').accordion('select', t);
}

/*
获取左侧导航的图标
根据提供的menuid从菜单数据中查找对应的图标类名
*/
function getIcon(menuid){
	var icon = 'icon ';
	$.each(_menus.menus, function(i, n) {
		$.each(n.menus, function(j, o) {
			if(o.menuid==menuid){
				icon += o.icon;
			}
		})
	})

	return icon;
}

/*
添加新的选项卡
用于在主区域中添加新的选项卡
如果选项卡已存在，则选择该选项卡。否则创建一个新选项卡
*/
function addTab(subtitle,url,icon){
	if(!$('#tabs').tabs('exists',subtitle)){
		$('#tabs').tabs('add',{
			title:subtitle,
			content:createFrame(url),
			closable:true,
			icon:icon
		});
	}else{
		$('#tabs').tabs('select',subtitle);
		$('#mm-tabupdate').click();
	}
	tabClose();
}

/*
创建iframe来显示页面内容
用于在选项卡内显示指定的URL内容
*/
function createFrame(url)
{
	var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}

/*
绑定选项卡的关闭事件
包括双击关闭和右键菜单关闭
*/
function tabClose()
{
	// 双击关闭选项卡
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close',subtitle);
	})

	// 绑定右键菜单
	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY
		});

		var subtitle =$(this).children(".tabs-closable").text();

		$('#mm').data("currtab",subtitle);
		$('#tabs').tabs('select',subtitle);
		return false;
	});
}

/*
绑定右键菜单事件
如刷新，关闭当前/其他/所有选项卡
*/
function tabCloseEven() {
	// 刷新选项卡
	$('#mm-tabupdate').click(function(){
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		$('#tabs').tabs('update',{
			tab:currTab,
			options:{
				content:createFrame(url)
			}
		})
	})

	// 关闭当前选项卡
	$('#mm-tabclose').click(function(){
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close',currtab_title);
	})

	// 关闭所有选项卡
	$('#mm-tabcloseall').click(function(){
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			$('#tabs').tabs('close',t);
		});
	});

	// 关闭除当前之外的选项卡
	$('#mm-tabcloseother').click(function(){
		$('#mm-tabcloseright').click();
		$('#mm-tabcloseleft').click();
	});
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function(){
		var nextall = $('.tabs-selected').nextAll();
		if(nextall.length==0){
			//msgShow('系统提示','后边没有啦~~','error');
			alert('后边没有啦~~');
			return false;
		}
		nextall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		if(prevall.length==0){
			alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});

	//退出
	$("#mm-exit").click(function(){
		$('#mm').menu('hide');
	})
}

/*
弹出消息窗口
显示不同类型的消息提示窗口
*/
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}
