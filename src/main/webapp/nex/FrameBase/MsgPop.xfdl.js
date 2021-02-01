(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("MsgPop");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(800,600);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize

            
            // UI Components Initialize
            obj = new Div("Div00","50","50","700","500",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("Div00");
            obj.set_border("1px solid black");
            this.addChild(obj.name, obj);

            obj = new Static("staId","99","39","560","30",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("0");
            obj.set_text("");
            obj.set_border("1px solid black");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("staRec","14","39","75","30",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("1");
            obj.set_text("받는 사람 :");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static00","15","89","74","26",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("2");
            obj.set_text("제목 :");
            this.Div00.addChild(obj.name, obj);

            obj = new Edit("edtTitle","98","84","561","31",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("3");
            obj.set_border("1px solid black");
            this.Div00.addChild(obj.name, obj);

            obj = new Button("btnSend","419","459","119","23",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("4");
            obj.set_text("쪽지 보내기");
            this.Div00.addChild(obj.name, obj);

            obj = new Button("btnCancel","560","459","119","23",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("5");
            obj.set_text("취소");
            this.Div00.addChild(obj.name, obj);

            obj = new WebBrowser("ckeditor","29","141","646","296",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("6");
            this.Div00.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",800,600,this,function(p){});
            obj.set_mobileorientation("landscape");
            this.addLayout(obj.name, obj);
            
            // BindItem Information
            obj = new BindItem("item0","Div00.form.staId","text","ds_chkList","id");
            this.addChild(obj.name, obj);
            obj.bind();
        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("MsgPop.xfdl", function() {
        var _win;
        this.MsgPop_onload = function(obj,e)
        {
        	var arrId = this.parent.param;
        	this.Div00.form.staId.set_text(arrId);

        	var domain = document.location.href;
            var arrdomain = domain.split('/');
            var currentfile = arrdomain.pop();
            domain = domain.replace(currentfile, "editor/editor.html");
           this.Div00.form.ckeditor.set_url(domain);

        };

        this.Div00_btnCancel_onclick = function(obj,e)
        {
        	this.close();
        };

        this.Div00_btnSend_onclick = function(obj,e)
        {
        	let id = this.Div00.form.staId.text;
        	let title = this.Div00.form.edtTitle.value;
        	let content =_win.callMethod("getData");

        	let send = id + "|" + title + "|" + content;
        	this.close(send);
        };


        this.Div00_ckeditor_onloadcompleted = function(obj,e)
        {
            _win = this.Div00.form.ckeditor.getProperty('window');
        };

        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.MsgPop_onload,this);
            this.Div00.form.btnSend.addEventHandler("onclick",this.Div00_btnSend_onclick,this);
            this.Div00.form.btnCancel.addEventHandler("onclick",this.Div00_btnCancel_onclick,this);
            this.Div00.form.ckeditor.addEventHandler("onloadcompleted",this.Div00_ckeditor_onloadcompleted,this);
        };

        this.loadIncludeScript("MsgPop.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
