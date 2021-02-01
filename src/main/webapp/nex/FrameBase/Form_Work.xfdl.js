(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Form_Work");
            this.set_titletext("Form_Work");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_login", this);
            obj._setContents("<ColumnInfo><Column id=\"id\" type=\"STRING\" size=\"256\"/><Column id=\"pw\" type=\"STRING\" size=\"256\"/><Column id=\"admin\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Static("Static01","0","0","50%","50%",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("");
            obj.set_background("antiquewhite");
            obj.set_visible("false");
            this.addChild(obj.name, obj);

            obj = new Div("loginForm","Static01:-287","Static01:-255","600","400",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("Div00");
            this.addChild(obj.name, obj);

            obj = new Div("loginBox","100","90","400","300",null,null,null,null,null,null,this.loginForm.form);
            obj.set_taborder("0");
            obj.set_text("");
            obj.set_borderRadius("20px");
            obj.set_background("url(\'theme::default/images/back_log.png\')");
            this.loginForm.addChild(obj.name, obj);

            obj = new Button("btnLogin","116","166","167","47",null,null,null,null,null,null,this.loginForm.form.loginBox.form);
            obj.set_taborder("0");
            obj.set_text("로그인");
            obj.set_cssclass("btn_white");
            this.loginForm.form.loginBox.addChild(obj.name, obj);

            obj = new CheckBox("chkLogin","229","237","120","25",null,null,null,null,null,null,this.loginForm.form.loginBox.form);
            obj.set_taborder("1");
            obj.set_text("로그인 유지");
            this.loginForm.form.loginBox.addChild(obj.name, obj);

            obj = new CheckBox("chkID","89","237","120","25",null,null,null,null,null,null,this.loginForm.form.loginBox.form);
            obj.set_taborder("2");
            obj.set_text("아이디 저장");
            this.loginForm.form.loginBox.addChild(obj.name, obj);

            obj = new Edit("edtID","85","49","230","36",null,null,null,null,null,null,this.loginForm.form.loginBox.form);
            obj.set_taborder("3");
            obj.set_displaynulltext("아이디를 입력해주세요");
            this.loginForm.form.loginBox.addChild(obj.name, obj);

            obj = new Edit("edtPW","85","109","230","36",null,null,null,null,null,null,this.loginForm.form.loginBox.form);
            obj.set_taborder("4");
            obj.set_displaynulltext("비밀번호를 입력해주세요");
            obj.set_password("true");
            this.loginForm.form.loginBox.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","Desktop_screen",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information

        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Form_Work.xfdl", function() {

        this.Form_Work_onload = function(obj,e)
        {
        	var id = nexacro.getPrivateProfile("id");
        	var login = nexacro.getPrivateProfile("login");
        	if(id != undefined && id.length > 0){
        		this.loginForm.form.loginBox.form.edtID.set_value(id);
        		this.loginForm.form.loginBox.form.chkID.set_value(true);
        	}
        	trace(login);
        	if(login != undefined && login != null){
        		var objApp = nexacro.getApplication();
        		objApp.mainframe.VFrameSet00.set_separatesize("0,*");
        	}

        };

        this.loginForm_loginBox_btnLogin_onclick = function(obj,e)
        {
        	var ID = this.loginForm.form.loginBox.form.edtID.value;
        	var PW = this.loginForm.form.loginBox.form.edtPW.value;

        	if(this.loginForm.form.loginBox.form.chkID.value){
        		nexacro.setPrivateProfile("id",ID);
        	}else{
        		nexacro.setPrivateProfile("id","");
        	}
        	if(ID==undefined || ID== null){
        		this.alert("아이디를 입력해주세요");
        	}
        	else if(PW==undefined || PW == null){
        		this.alert("비밀번호를 입력해주세요");
        	}else{
        		this.transaction(
        				"login"
        				,"/login.nex"
        				,""
        				,"ds_login=out_ds"
        				,"id="+nexacro.wrapQuote(ID) + "pw="+nexacro.wrapQuote(PW)
        				,"fn_login_callback"
        			);


        	}

        };
        this.fn_login_callback=function(id,ErrorCode,ErrorMsg){
        	trace("id : "+id +"ErrorMsg :" + ErrorMsg +":ErrorCode :" +ErrorCode);
        	trace(this.ds_login.rowcount);
        	if(this.ds_login.rowcount > 0){
        			if(this.loginForm.form.loginBox.form.chkLogin.value){
        				nexacro.setPrivateProfile("login","login");
        			}else{
        				nexacro.setPrivateProfile("login","");
        			}
        			var objApp = nexacro.getApplication();
        			objApp.mainframe.VFrameSet00.set_separatesize("0,*");
        	}else{
        		alert("로그인에 실패했습니다");
        	}
        }

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.Form_Work_onload,this);
            this.loginForm.form.loginBox.form.btnLogin.addEventHandler("onclick",this.loginForm_loginBox_btnLogin_onclick,this);
        };

        this.loadIncludeScript("Form_Work.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
