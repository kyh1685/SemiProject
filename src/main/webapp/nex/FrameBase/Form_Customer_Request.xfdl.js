(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("Form_Customer_Request");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(990,600);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_service", this);
            obj._setContents("<ColumnInfo><Column id=\"chk\" type=\"INT\" size=\"256\"/><Column id=\"seq\" type=\"INT\" size=\"256\"/><Column id=\"writer\" type=\"STRING\" size=\"256\"/><Column id=\"title\" type=\"STRING\" size=\"256\"/><Column id=\"contents\" type=\"STRING\" size=\"256\"/><Column id=\"answer\" type=\"STRING\" size=\"256\"/><Column id=\"write_date\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_combo", this);
            obj._setContents("<ColumnInfo><Column id=\"id\" type=\"STRING\" size=\"256\"/><Column id=\"name\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"id\">writer</Col><Col id=\"name\">작성자</Col></Row><Row><Col id=\"id\">title</Col><Col id=\"name\">제목</Col></Row><Row><Col id=\"id\">write_date</Col><Col id=\"name\">작성일</Col></Row></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Div("Div00","40","40","904","456",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("");
            obj.set_border("1px solid black");
            this.addChild(obj.name, obj);

            obj = new Edit("edt_search","269","16","186","35",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("0");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static00","11","24","56","30",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("1");
            obj.set_text("항목 : ");
            obj.set_textAlign("center");
            obj.set_border("0px none, 0px none, 1px groove black");
            obj.set_font("bold 12px/normal \"Gulim\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static00_00","216","21","43","30",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("2");
            obj.set_text("기입 :");
            obj.set_textAlign("center");
            obj.set_border("0px none, 0px none, 1px groove black");
            obj.set_font("bold 12px/normal \"Gulim\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Edit("Edit02","483","309","413","110",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("3");
            obj.set_border("1px solid black");
            this.Div00.addChild(obj.name, obj);

            obj = new Edit("Edit02_00","552","129","258","35",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("4");
            obj.set_border("1px solid black");
            this.Div00.addChild(obj.name, obj);

            obj = new Button("btn_search","465","15","36","36",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("5");
            obj.set_text("찾기");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static01","483","67","413","44",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("6");
            obj.set_text("답장 쓰기");
            obj.set_border("1px solid black");
            obj.set_font("bold 28px/normal \"Gulim\"");
            obj.set_textAlign("center");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static01_00","9","67","420","44",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("7");
            obj.set_text("목록 보기");
            obj.set_border("1px solid black");
            obj.set_font("bold 28px/normal \"Gulim\"");
            obj.set_textAlign("center");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static02","440","309","39","35",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("8");
            obj.set_text("Re : ");
            obj.set_font("bold 20px/normal \"Gulim\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Grid("Grid00","9","130","421","284",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("9");
            obj.set_binddataset("ds_service");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"40\"/><Column size=\"51\"/><Column size=\"62\"/><Column size=\"144\"/><Column size=\"124\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"bind:chk\" displaytype=\"checkboxcontrol\" edittype=\"checkbox\"/><Cell col=\"1\" text=\"seq\"/><Cell col=\"2\" text=\"writer\"/><Cell col=\"3\" text=\"title\"/><Cell col=\"4\" text=\"write_date\"/></Band><Band id=\"body\"><Cell text=\"bind:chk\" displaytype=\"checkboxcontrol\" edittype=\"checkbox\"/><Cell col=\"1\" text=\"bind:seq\"/><Cell col=\"2\" text=\"bind:writer\"/><Cell col=\"3\" text=\"bind:title\"/><Cell col=\"4\" text=\"bind:write_date\"/></Band></Format></Formats>");
            this.Div00.addChild(obj.name, obj);

            obj = new Static("Static02_00","483","129","59","35",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("10");
            obj.set_text("Title : ");
            obj.set_font("bold 20px/normal \"Gulim\"");
            this.Div00.addChild(obj.name, obj);

            obj = new Edit("Edit01","483","184","413","110",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("11");
            obj.set_border("1px solid black");
            this.Div00.addChild(obj.name, obj);

            obj = new Combo("cb_search","74","20","131","33",null,null,null,null,null,null,this.Div00.form);
            obj.set_taborder("12");
            obj.set_innerdataset("ds_combo");
            obj.set_codecolumn("id");
            obj.set_datacolumn("name");
            obj.set_text("Combo00");
            this.Div00.addChild(obj.name, obj);

            obj = new Button("btn_Upd","837","506","106","60",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("확정");
            this.addChild(obj.name, obj);

            obj = new Button("btn_Del","360","506","106","60",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("삭제");
            this.addChild(obj.name, obj);

            obj = new Button("btn_retrive","42","512","88","48",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("갱신");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",990,600,this,function(p){});
            obj.set_mobileorientation("landscape");
            obj.set_stepcount("0");
            this.addLayout(obj.name, obj);
            
            // BindItem Information
            obj = new BindItem("item0","Div00.form.Edit02_00","value","ds_service","title");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item1","Div00.form.Edit01","value","ds_service","contents");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item2","Div00.form.Edit02","value","ds_service","answer");
            this.addChild(obj.name, obj);
            obj.bind();
        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("Form_Customer_Request.xfdl", function() {
        this.fn_callback = function(id,ErrorCode,ErrorMsg){	//콜백함수
        	trace(id);
        	trace(ErrorMsg);
        	trace(ErrorCode);
        }

        this.fn_update_board = function(id,url){	//업데이트 따로 뺀것
          this.transaction(
                    id
                    ,url
                    ,"in_ds=ds_service:U"
                    ,""
                    ,""
                    ,"fn_callback"
                 )
        }
        this.btn_retrive_onclick = function(obj,e)	//갱신 버튼
        {
        	this.transaction(
        			"ds_Load" //id
        			,"/cr/dsLoad.nex"//url
        			,""// inData
        			,"ds_service=out_ds"// outData
        			,""//strArg
        			,"fn_callback"//callback
        		);
        	this.ds_service.filter("");
        };

        this.btn_Del_onclick = function(obj,e)		//삭제 버튼
        {
        	let arr = this.ds_service.extractRows("chk==1");

        	if(arr.length==0 || arr.length== -1){alert("선택된 항목이 없습니다.");return;}

        	this.ds_service.deleteMultiRows(arr);
        	this.fn_update_board("dsDel","/cr/dsDel.nex");
        };




        this.Div00_btn_search_onclick = function(obj,e)	//찾기 버튼
        {
        	var sCol = this.Div00.form.cb_search.value;
        	var sVar = this.Div00.form.edt_search.value;
        	var sFilter = sCol + "=='" + sVar + "'";

        	this.ds_service.filter(sFilter);
        };


        this.Form_Customer_Request_onload = function(obj,e)	//온로드
        {
        	this.transaction(
        			"ds_Load" //id
        			,"/cr/dsLoad.nex"//url
        			,""// inData
        			,"ds_service=out_ds"// outData
        			,""//strArg
        			,"fn_callback"//callback
        		);
        };

        this.btn_Upd_onclick = function(obj,e)		//업데이트 요청
        {
        	this.fn_update_board("dsUpd","/cr/dsUpd.nex");
        };



        this.Div00_Grid00_onheadclick = function(obj,e)		// 모두 체크하기
        {
        	let flag = obj.getCellProperty("Head",0,"text");
        	let check = flag==0?1:0;

        	if(e.cell==0){

        		obj.setCellProperty("Head",0,"text",check);
        		for(let i = 0;i<this.ds_service.rowcount;i++){
        			this.ds_service.setColumn(i,0,check);
        		}
        	}
        };





        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.Form_Customer_Request_onload,this);
            this.Div00.form.btn_search.addEventHandler("onclick",this.Div00_btn_search_onclick,this);
            this.Div00.form.Grid00.addEventHandler("onheadclick",this.Div00_Grid00_onheadclick,this);
            this.btn_Upd.addEventHandler("onclick",this.btn_Upd_onclick,this);
            this.btn_Del.addEventHandler("onclick",this.btn_Del_onclick,this);
            this.btn_retrive.addEventHandler("onclick",this.btn_retrive_onclick,this);
        };

        this.loadIncludeScript("Form_Customer_Request.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
