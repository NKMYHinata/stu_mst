/**
 * 扩展easyui表单的验证
 */

$.extend($.fn.validatebox.defaults.rules, {
	// 验证汉字
	CHS: {
		validator: function(value) {
			return /^[\u0391-\uFFE5]+$/.test(value);
		},
		message: '只能输入汉字'
	},
	// 移动手机号码验证
	mobile: { // value值为文本框中的值
		validator: function(value) {
			let reg = /^1[3|4|5|8|9]\d{9}$/;
			return reg.test(value);
		},
		message: '请输入有效的手机号码'
	},
	// 只能为数字
	number: { // value值为文本框中的值
		validator: function(value) {
			let reg = /^[0-9]*$/;
			return reg.test(value);
		},
		message: '只能输入数字'
	},
	// 验证账号是否重复
	repeat: {
		validator: function(value) {
			let flag = true;
			$.ajax({
				type: "post",
				async: false,
				url: "SystemServlet?method=AllAccount&t=" + new Date().getTime(),
				success: function(data) { // 异步请求检查账号是否重复
					let account = $.parseJSON(data);
					for (let i = 0; i < account.length; i++) {
						if (value == account[i]) {
							flag = false;
							break;
						}
					}
				}
			});
			return flag;
		},
		message: '账号已存在'
	},
	// 验证课程是否重复
	repeat_course: {
		validator: function(value) {
			let flag = true;
			$.ajax({
				type: "post",
				async: false,
				url: "CourseServlet?method=CourseList&t=" + new Date().getTime(),
				success: function(data) { // 异步请求检查课程是否重复
					let course = $.parseJSON(data);
					for (let i = 0; i < course.length; i++) {
						if (value == course[i].name) {
							flag = false;
							break;
						}
					}
				}
			});
			return flag;
		},
		message: '课程名称已存在'
	},
	// 验证年级是否重复
	repeat_grade: {
		validator: function(value) {
			let flag = true;
			$.ajax({
				type: "post",
				async: false,
				url: "GradeServlet?method=GradeList&t=" + new Date().getTime(),
				success: function(data) { // 异步请求检查年级是否重复
					let grade = $.parseJSON(data);
					for (let i = 0; i < grade.length; i++) {
						if (value == grade[i].name) {
							flag = false;
							break;
						}
					}
				}
			});
			return flag;
		},
		message: '年级名称已存在'
	},
	// 验证班级是否重复
	repeat_clazz: {
		validator: function(value, param) {
			let gradeid = $(param[0]).combobox("getValue");
			let flag = true;
			$.ajax({
				type: "post",
				async: false,
				data: { gradeid: gradeid },
				url: "ClazzServlet?method=ClazzList&t=" + new Date().getTime(),
				success: function(data) { // 异步请求检查班级是否重复
					let clazz = $.parseJSON(data);
					for (let i = 0; i < clazz.length; i++) {
						if (value == clazz[i].name) {
							flag = false;
							break;
						}
					}
				}
			});
			return flag;
		},
		message: '该年级下已存在同名班级'
	},
	// 验证两个值是否相同（例如密码和确认密码）
	equals: {
		validator: function(value, param) {
			return $(param[0]).val() === value;
		},
		message: '两次输入不一致'
	},
	// 密码规则验证
	password: {
		validator: function(value) {
			let reg = /^[a-zA-Z0-9]{6,16}$/;
			return reg.test(value);
		},
		message: '密码长度为6-16位，只能包含英文和数字'
	},
	// 验证输入的旧密码是否正确
	oldPassword: {
		validator: function(value, param) {
			return param === value;
		},
		message: '旧密码不正确'
	},
	// 国内邮编验证
	zipcode: {
		validator: function(value) {
			let reg = /^[1-9]\d{5}$/;
			return reg.test(value);
		},
		message: '请输入有效的邮编'
	},
	// 用户账号验证（只能包括数字、字母和下划线）
	account: {
		validator: function(value, param) {
			if (value.length < param[0] || value.length > param[1]) {
				$.fn.validatebox.defaults.rules.account.message = '用户名长度必须在' + param[0] + '至' + param[1] + '之间';
				return false;
			} else {
				return /^[\w]+$/.test(value);
			}
		},
		message: '用户名只能包含数字、字母和下划线'
	}
});
