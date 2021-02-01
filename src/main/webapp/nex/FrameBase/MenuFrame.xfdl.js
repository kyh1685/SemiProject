(function()
{
    return function()
    {
        if (!this._is_form)
            return;
        
        var obj = null;
        
        this.on_create = function()
        {
            this.set_name("MenuFrame");
            this.set_titletext("New Form");
            if (Form == this.constructor)
            {
                this._setFormPosition(1280,720);
            }
            
            // Object(Dataset, ExcelExportObject) Initialize
            obj = new Dataset("ds_member", this);
            obj._setContents("<ColumnInfo><Column id=\"chk\" type=\"STRING\" size=\"256\"/><Column id=\"id\" type=\"STRING\" size=\"256\"/><Column id=\"name\" type=\"STRING\" size=\"256\"/><Column id=\"pw\" type=\"STRING\" size=\"256\"/><Column id=\"contact\" type=\"STRING\" size=\"256\"/><Column id=\"email\" type=\"STRING\" size=\"256\"/><Column id=\"mileage\" type=\"INT\" size=\"256\"/><Column id=\"black_list\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_blackList", this);
            obj._setContents("<ColumnInfo><Column id=\"id\" type=\"STRING\" size=\"256\"/><Column id=\"name\" type=\"STRING\" size=\"256\"/><Column id=\"pw\" type=\"STRING\" size=\"256\"/><Column id=\"contact\" type=\"STRING\" size=\"256\"/><Column id=\"email\" type=\"STRING\" size=\"256\"/><Column id=\"mileage\" type=\"INT\" size=\"256\"/><Column id=\"black_list\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_Msg", this);
            obj._setContents("<ColumnInfo><Column id=\"receiver\" type=\"STRING\" size=\"256\"/><Column id=\"title\" type=\"STRING\" size=\"256\"/><Column id=\"contents\" type=\"STRING\" size=\"256\"/><Column id=\"sender\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_member00", this);
            obj._setContents("<ColumnInfo><Column id=\"chk\" type=\"STRING\" size=\"256\"/><Column id=\"id\" type=\"STRING\" size=\"256\"/><Column id=\"name\" type=\"STRING\" size=\"256\"/><Column id=\"pw\" type=\"STRING\" size=\"256\"/><Column id=\"contact\" type=\"STRING\" size=\"256\"/><Column id=\"email\" type=\"STRING\" size=\"256\"/><Column id=\"mileage\" type=\"INT\" size=\"256\"/><Column id=\"black_list\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"id\">1</Col><Col id=\"name\">1</Col><Col id=\"pw\">1</Col><Col id=\"contact\">1</Col></Row><Row><Col id=\"id\">2</Col></Row><Row><Col id=\"id\">3</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_blackList00", this);
            obj._setContents("<ColumnInfo><Column id=\"chk\" type=\"STRING\" size=\"256\"/><Column id=\"id\" type=\"STRING\" size=\"256\"/><Column id=\"name\" type=\"STRING\" size=\"256\"/><Column id=\"pw\" type=\"STRING\" size=\"256\"/><Column id=\"contact\" type=\"STRING\" size=\"256\"/><Column id=\"email\" type=\"STRING\" size=\"256\"/><Column id=\"mileage\" type=\"INT\" size=\"256\"/><Column id=\"black_list\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_Msg00", this);
            obj._setContents("<ColumnInfo><Column id=\"receiver\" type=\"STRING\" size=\"256\"/><Column id=\"title\" type=\"STRING\" size=\"256\"/><Column id=\"contents\" type=\"STRING\" size=\"256\"/><Column id=\"sender\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_report", this);
            obj._setContents("<ColumnInfo><Column id=\"reportSeq\" type=\"INT\" size=\"20\"/><Column id=\"goodSeq\" type=\"INT\" size=\"20\"/><Column id=\"reportedUser\" type=\"STRING\" size=\"50\"/><Column id=\"reportCode\" type=\"INT\" size=\"20\"/><Column id=\"reportContents\" type=\"STRING\" size=\"1000\"/><Column id=\"reportWriter\" type=\"STRING\" size=\"50\"/><Column id=\"reportDate\" type=\"DATE\" size=\"20\"/><Column id=\"reportMemo\" type=\"STRING\" size=\"200\"/></ColumnInfo><Rows><Row><Col id=\"reportSeq\">1</Col><Col id=\"goodSeq\">5</Col><Col id=\"reportedUser\">user</Col><Col id=\"reportCode\">3</Col><Col id=\"reportContents\">Test중인데 어떻게 띄울지 고민중이에요</Col><Col id=\"reportWriter\">writer</Col><Col id=\"reportDate\">20201223</Col><Col id=\"reportMemo\">관리자가 특이사항 메모같은거  할수 있게끔</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_report_option", this);
            obj._setContents("<ColumnInfo><Column id=\"code\" type=\"INT\" size=\"256\"/><Column id=\"name\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"code\">1</Col><Col id=\"name\">부적절한 상품 등록</Col></Row><Row><Col id=\"code\">2</Col><Col id=\"name\">잦은 응답 부재/잠수</Col></Row><Row><Col id=\"code\">3</Col><Col id=\"name\">부적절한 언어 표현</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_service", this);
            obj._setContents("<ColumnInfo><Column id=\"chk\" type=\"INT\" size=\"256\"/><Column id=\"seq\" type=\"INT\" size=\"256\"/><Column id=\"writer\" type=\"STRING\" size=\"256\"/><Column id=\"title\" type=\"STRING\" size=\"256\"/><Column id=\"contents\" type=\"STRING\" size=\"256\"/><Column id=\"answer\" type=\"STRING\" size=\"256\"/><Column id=\"write_date\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_combo", this);
            obj._setContents("<ColumnInfo><Column id=\"id\" type=\"STRING\" size=\"256\"/><Column id=\"name\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"id\">writer</Col><Col id=\"name\">작성자</Col></Row><Row><Col id=\"id\">title</Col><Col id=\"name\">제목</Col></Row><Row><Col id=\"id\">write_date</Col><Col id=\"name\">작성일</Col></Row></Rows>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_login", this);
            obj._setContents("<ColumnInfo><Column id=\"id\" type=\"STRING\" size=\"256\"/><Column id=\"pw\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_members", this);
            obj._setContents("<ColumnInfo><Column id=\"chk\" type=\"INT\" size=\"256\"/><Column id=\"id\" type=\"STRING\" size=\"256\"/><Column id=\"pw\" type=\"STRING\" size=\"256\"/><Column id=\"email\" type=\"STRING\" size=\"256\"/><Column id=\"black_list\" type=\"STRING\" size=\"256\"/><Column id=\"admin\" type=\"STRING\" size=\"256\"/><Column id=\"mileage\" type=\"INT\" size=\"256\"/><Column id=\"name\" type=\"STRING\" size=\"256\"/><Column id=\"contact\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("ds_goods", this);
            obj._setContents("<ColumnInfo><Column id=\"chk\" type=\"STRING\" size=\"256\"/><Column id=\"goodSeq\" type=\"INT\" size=\"256\"/><Column id=\"goodWriter\" type=\"STRING\" size=\"256\"/><Column id=\"goodName\" type=\"STRING\" size=\"256\"/><Column id=\"goodPrice\" type=\"INT\" size=\"256\"/><Column id=\"cateCode\" type=\"INT\" size=\"256\"/><Column id=\"goodDes\" type=\"STRING\" size=\"256\"/><Column id=\"goodImg\" type=\"STRING\" size=\"256\"/><Column id=\"goodDate\" type=\"STRING\" size=\"256\"/></ColumnInfo>");
            this.addChild(obj.name, obj);


            obj = new Dataset("cateCode", this);
            obj._setContents("<ColumnInfo><Column id=\"id\" type=\"STRING\" size=\"256\"/><Column id=\"name\" type=\"STRING\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"id\">1</Col><Col id=\"name\">삽니다</Col></Row><Row><Col id=\"id\">2</Col><Col id=\"name\">팝니다</Col></Row></Rows>");
            this.addChild(obj.name, obj);
            
            // UI Components Initialize
            obj = new Static("Static00","0","0","50%","50%",null,null,null,null,null,null,this);
            obj.set_taborder("1");
            obj.set_text("");
            obj.set_background("antiquewhite");
            obj.set_visible("false");
            this.addChild(obj.name, obj);

            obj = new Div("menuForm","Static00:-600","Static00:-350","1200","700",null,null,null,null,null,null,this);
            obj.set_taborder("0");
            obj.set_text("Div00");
            this.addChild(obj.name, obj);

            obj = new Tab("Tab00","50","80","1100","600",null,null,null,null,null,null,this.menuForm.form);
            obj.set_taborder("0");
            obj.set_tabindex("0");
            obj.set_tabposition("left");
            this.menuForm.addChild(obj.name, obj);

            obj = new Tabpage("blManage",this.menuForm.form.Tab00);
            obj.set_text("블랙리스트 관리");
            obj.set_border("1px solid black");
            this.menuForm.form.Tab00.addChild(obj.name, obj);

            obj = new Grid("blackListGrid","25","73","935","500",null,null,null,null,null,null,this.menuForm.form.Tab00.blManage.form);
            obj.set_taborder("0");
            obj.set_binddataset("ds_blackList");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"98\"/><Column size=\"105\"/><Column size=\"115\"/><Column size=\"191\"/><Column size=\"216\"/><Column size=\"103\"/><Column size=\"75\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\" 아이디\"/><Cell col=\"1\" text=\"성 명\"/><Cell col=\"2\" text=\"비밀번호\"/><Cell col=\"3\" text=\"전화번호\"/><Cell col=\"4\" text=\"이메일\"/><Cell col=\"5\" text=\"마일리지\"/><Cell col=\"6\" text=\"블랙리스트\"/></Band><Band id=\"body\"><Cell text=\"bind:id\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:name\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:pw\" textAlign=\"center\"/><Cell col=\"3\" text=\"bind:contact\" textAlign=\"center\"/><Cell col=\"4\" text=\"bind:email\" textAlign=\"center\"/><Cell col=\"5\" text=\"bind:mileage\"/><Cell col=\"6\" text=\"bind:black_list\" displaytype=\"checkboxcontrol\" edittype=\"checkbox\" checkboxfalsevalue=\"N\" checkboxtruevalue=\"Y\"/></Band></Format></Formats>");
            this.menuForm.form.Tab00.blManage.addChild(obj.name, obj);

            obj = new Static("Static00","31","20","250","50",null,null,null,null,null,null,this.menuForm.form.Tab00.blManage.form);
            obj.set_taborder("1");
            obj.set_text("블랙리스트 관리");
            obj.set_cssclass("sta_title");
            this.menuForm.form.Tab00.blManage.addChild(obj.name, obj);

            obj = new Tabpage("blSelect",this.menuForm.form.Tab00);
            obj.set_text("신고글 조회");
            obj.set_border("1px solid black");
            this.menuForm.form.Tab00.addChild(obj.name, obj);

            obj = new Grid("Grid00","29","73","520","500",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form);
            obj.set_taborder("0");
            obj.set_binddataset("ds_report");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"59\"/><Column size=\"202\"/><Column size=\"97\"/><Column size=\"141\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell text=\"No\"/><Cell col=\"1\" text=\"신고 분류\"/><Cell col=\"2\" text=\"작성자\"/><Cell col=\"3\" text=\"작성날짜\"/></Band><Band id=\"body\"><Cell text=\"bind:reportSeq\" textAlign=\"center\"/><Cell col=\"1\" text=\"bind:reportCode\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:reportWriter\" textAlign=\"center\"/><Cell col=\"3\" text=\"bind:reportDate\"/></Band></Format></Formats>");
            this.menuForm.form.Tab00.blSelect.addChild(obj.name, obj);

            obj = new Div("Div00","565","73","390","500",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form);
            obj.set_taborder("1");
            obj.set_text("Div00");
            obj.set_border("1px solid #c1c1c1");
            this.menuForm.form.Tab00.blSelect.addChild(obj.name, obj);

            obj = new Static("sta_con","14","120","350","178",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form.Div00.form);
            obj.set_taborder("0");
            obj.set_text("Static00");
            obj.set_border("1px solid #c1c1c1");
            this.menuForm.form.Tab00.blSelect.form.Div00.addChild(obj.name, obj);

            obj = new Static("Static00","14","92","109","29",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form.Div00.form);
            obj.set_taborder("1");
            obj.set_text("신고내용");
            this.menuForm.form.Tab00.blSelect.form.Div00.addChild(obj.name, obj);

            obj = new Combo("Combo00","14","61","350","31",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form.Div00.form);
            obj.set_taborder("2");
            obj.set_innerdataset("ds_report_option");
            obj.set_codecolumn("code");
            obj.set_datacolumn("name");
            obj.set_text("Combo00");
            this.menuForm.form.Tab00.blSelect.form.Div00.addChild(obj.name, obj);

            obj = new Static("Static00_00","14","34","109","29",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form.Div00.form);
            obj.set_taborder("3");
            obj.set_text("신고코드");
            this.menuForm.form.Tab00.blSelect.form.Div00.addChild(obj.name, obj);

            obj = new Static("Static00_00_00","14","6","69","29",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form.Div00.form);
            obj.set_taborder("4");
            obj.set_text("게시물 번호");
            this.menuForm.form.Tab00.blSelect.form.Div00.addChild(obj.name, obj);

            obj = new Static("Static00_00_00_00","93","8","60","25",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form.Div00.form);
            obj.set_taborder("5");
            obj.set_text("");
            obj.set_border("1px solid #c1c1c1");
            this.menuForm.form.Tab00.blSelect.form.Div00.addChild(obj.name, obj);

            obj = new Static("Static00_00_00_01","169","6","69","29",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form.Div00.form);
            obj.set_taborder("6");
            obj.set_text("신고된 유저");
            this.menuForm.form.Tab00.blSelect.form.Div00.addChild(obj.name, obj);

            obj = new Edit("Edit00","246","8","118","25",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form.Div00.form);
            obj.set_taborder("7");
            this.menuForm.form.Tab00.blSelect.form.Div00.addChild(obj.name, obj);

            obj = new Static("Static00_00_00_01_00","183","339","69","29",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form.Div00.form);
            obj.set_taborder("8");
            obj.set_text("작성자");
            this.menuForm.form.Tab00.blSelect.form.Div00.addChild(obj.name, obj);

            obj = new Static("Static01","237","312","127","25",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form.Div00.form);
            obj.set_taborder("9");
            obj.set_text("Static01");
            obj.set_border("1px solid #c1c1c1");
            this.menuForm.form.Tab00.blSelect.form.Div00.addChild(obj.name, obj);

            obj = new Static("Static02","244","341","120","25",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form.Div00.form);
            obj.set_taborder("10");
            obj.set_text("Static02");
            obj.set_border("1px solid #c1c1c1");
            this.menuForm.form.Tab00.blSelect.form.Div00.addChild(obj.name, obj);

            obj = new Edit("Edit01","14","380","350","78",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form.Div00.form);
            obj.set_taborder("11");
            this.menuForm.form.Tab00.blSelect.form.Div00.addChild(obj.name, obj);

            obj = new Static("Static00_00_00_01_00_00","14","355","88","29",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form.Div00.form);
            obj.set_taborder("12");
            obj.set_text("관리자 메모");
            this.menuForm.form.Tab00.blSelect.form.Div00.addChild(obj.name, obj);

            obj = new Static("Static00_00_00_01_00_01","174","302","69","29",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form.Div00.form);
            obj.set_taborder("13");
            obj.set_text("작성날짜");
            this.menuForm.form.Tab00.blSelect.form.Div00.addChild(obj.name, obj);

            obj = new Button("btn_reportMemo","293","462","71","21",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form.Div00.form);
            obj.set_taborder("14");
            obj.set_text("메모 등록");
            obj.set_cssclass("btn_default");
            this.menuForm.form.Tab00.blSelect.form.Div00.addChild(obj.name, obj);

            obj = new Static("Static00","596","573","25","25",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form);
            obj.set_taborder("2");
            obj.set_text("Static00");
            obj.set_cssclass("sta_default");
            obj.set_visible("false");
            this.menuForm.form.Tab00.blSelect.addChild(obj.name, obj);

            obj = new Static("Static01","36","15","250","50",null,null,null,null,null,null,this.menuForm.form.Tab00.blSelect.form);
            obj.set_taborder("3");
            obj.set_text("신고글 조회");
            obj.set_cssclass("sta_title");
            this.menuForm.form.Tab00.blSelect.addChild(obj.name, obj);

            obj = new Tabpage("pdManage",this.menuForm.form.Tab00);
            obj.set_text("상품관리");
            obj.set_border("1px solid black");
            this.menuForm.form.Tab00.addChild(obj.name, obj);

            obj = new Grid("Grid00","24","179","400","342",null,null,null,null,null,null,this.menuForm.form.Tab00.pdManage.form);
            obj.set_taborder("0");
            obj.set_binddataset("ds_goods");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"44\"/><Column size=\"70\"/><Column size=\"159\"/><Column size=\"127\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell displaytype=\"none\" edittype=\"none\"/><Cell col=\"1\" text=\"번호\"/><Cell col=\"2\" text=\"상품명\"/><Cell col=\"3\" text=\"등록 일자\"/></Band><Band id=\"body\"><Cell text=\"bind:chk\" displaytype=\"checkboxcontrol\" edittype=\"checkbox\"/><Cell col=\"1\" text=\"bind:goodSeq\" textAlign=\"center\"/><Cell col=\"2\" text=\"bind:goodName\" textAlign=\"center\"/><Cell col=\"3\" text=\"bind:goodDate\" textAlign=\"center\"/></Band></Format></Formats>");
            this.menuForm.form.Tab00.pdManage.addChild(obj.name, obj);

            obj = new Static("Static00","24","119","400","50",null,null,null,null,null,null,this.menuForm.form.Tab00.pdManage.form);
            obj.set_taborder("1");
            obj.set_text("목록 보기");
            obj.set_textAlign("center");
            obj.set_cssclass("sta_default");
            this.menuForm.form.Tab00.pdManage.addChild(obj.name, obj);

            obj = new Div("Div00","439","9","540","545",null,null,null,null,null,null,this.menuForm.form.Tab00.pdManage.form);
            obj.set_taborder("2");
            obj.set_text("Div00");
            this.menuForm.form.Tab00.pdManage.addChild(obj.name, obj);

            obj = new Static("Static01_00","11","53","500","40",null,null,null,null,null,null,this.menuForm.form.Tab00.pdManage.form.Div00.form);
            obj.set_taborder("0");
            obj.set_text("정 보");
            obj.set_textAlign("center");
            obj.set_cssclass("sta_default");
            this.menuForm.form.Tab00.pdManage.form.Div00.addChild(obj.name, obj);

            obj = new Static("staWriter","11","169","205","40",null,null,null,null,null,null,this.menuForm.form.Tab00.pdManage.form.Div00.form);
            obj.set_taborder("1");
            obj.set_text("");
            obj.set_border("1px solid #c1c1c1");
            obj.set_textAlign("center");
            this.menuForm.form.Tab00.pdManage.form.Div00.addChild(obj.name, obj);

            obj = new ImageViewer("image","11","288","205","257",null,null,null,null,null,null,this.menuForm.form.Tab00.pdManage.form.Div00.form);
            obj.set_taborder("2");
            obj.set_text("ImageViewer00");
            this.menuForm.form.Tab00.pdManage.form.Div00.addChild(obj.name, obj);

            obj = new Edit("edtName","11","115","500","42",null,null,null,null,null,null,this.menuForm.form.Tab00.pdManage.form.Div00.form);
            obj.set_taborder("3");
            obj.set_border("1px solid #c1c1c1");
            obj.set_textAlign("center");
            this.menuForm.form.Tab00.pdManage.form.Div00.addChild(obj.name, obj);

            obj = new Combo("Combo00","11","218","205","42",null,null,null,null,null,null,this.menuForm.form.Tab00.pdManage.form.Div00.form);
            obj.set_taborder("4");
            obj.set_innerdataset("cateCode");
            obj.set_codecolumn("id");
            obj.set_datacolumn("name");
            obj.set_text("Combo00");
            this.menuForm.form.Tab00.pdManage.form.Div00.addChild(obj.name, obj);

            obj = new TextArea("taDes","669","178","282","379",null,null,null,null,null,null,this.menuForm.form.Tab00.pdManage.form);
            obj.set_taborder("3");
            this.menuForm.form.Tab00.pdManage.addChild(obj.name, obj);

            obj = new Button("btnDel","169","535","123","44",null,null,null,null,null,null,this.menuForm.form.Tab00.pdManage.form);
            obj.set_taborder("4");
            obj.set_text("삭제");
            obj.set_cssclass("btn_default");
            this.menuForm.form.Tab00.pdManage.addChild(obj.name, obj);

            obj = new Edit("edtSearch","160","68","160","31",null,null,null,null,null,null,this.menuForm.form.Tab00.pdManage.form);
            obj.set_taborder("5");
            this.menuForm.form.Tab00.pdManage.addChild(obj.name, obj);

            obj = new Button("btnSearch","334","68","90","30",null,null,null,null,null,null,this.menuForm.form.Tab00.pdManage.form);
            obj.set_taborder("6");
            obj.set_text("검색");
            obj.set_cssclass("btn_default");
            this.menuForm.form.Tab00.pdManage.addChild(obj.name, obj);

            obj = new Combo("filter","24","69","120","29",null,null,null,null,null,null,this.menuForm.form.Tab00.pdManage.form);
            obj.set_taborder("7");
            obj.set_codecolumn("codecolumn");
            obj.set_datacolumn("datacolumn");
            var menuForm_form_Tab00_pdManage_form_filter_innerdataset = new nexacro.NormalDataset("menuForm_form_Tab00_pdManage_form_filter_innerdataset", obj);
            menuForm_form_Tab00_pdManage_form_filter_innerdataset._setContents("<ColumnInfo><Column id=\"codecolumn\" size=\"256\"/><Column id=\"datacolumn\" size=\"256\"/></ColumnInfo><Rows><Row><Col id=\"codecolumn\">goodSeq</Col><Col id=\"datacolumn\">번호</Col></Row><Row><Col id=\"codecolumn\">goodName</Col><Col id=\"datacolumn\">상품명</Col></Row><Row><Col id=\"codecolumn\">goodDes</Col><Col id=\"datacolumn\">상품 내용</Col></Row></Rows>");
            obj.set_innerdataset(menuForm_form_Tab00_pdManage_form_filter_innerdataset);
            obj.set_text("Combo00");
            this.menuForm.form.Tab00.pdManage.addChild(obj.name, obj);

            obj = new Button("reset","308","536","116","44",null,null,null,null,null,null,this.menuForm.form.Tab00.pdManage.form);
            obj.set_taborder("8");
            obj.set_text("초기화");
            obj.set_cssclass("btn_default");
            this.menuForm.form.Tab00.pdManage.addChild(obj.name, obj);

            obj = new Static("Static01","27","20","250","50",null,null,null,null,null,null,this.menuForm.form.Tab00.pdManage.form);
            obj.set_taborder("9");
            obj.set_text("상품관리");
            obj.set_cssclass("sta_title");
            this.menuForm.form.Tab00.pdManage.addChild(obj.name, obj);

            obj = new Tabpage("csManage",this.menuForm.form.Tab00);
            obj.set_text("문의사항 관리");
            obj.set_border("1px solid black");
            this.menuForm.form.Tab00.addChild(obj.name, obj);

            obj = new Div("Div00","24","73","936","500",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form);
            obj.set_taborder("0");
            obj.set_text("");
            obj.set_border("1px solid #c1c1c1");
            this.menuForm.form.Tab00.csManage.addChild(obj.name, obj);

            obj = new Edit("edt_search","259","15","170","30",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form.Div00.form);
            obj.set_taborder("0");
            this.menuForm.form.Tab00.csManage.form.Div00.addChild(obj.name, obj);

            obj = new Static("Static00","11","15","56","30",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form.Div00.form);
            obj.set_taborder("1");
            obj.set_text("항목 : ");
            obj.set_textAlign("center");
            obj.set_border("0px none");
            this.menuForm.form.Tab00.csManage.form.Div00.addChild(obj.name, obj);

            obj = new Static("Static00_00","206","15","43","30",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form.Div00.form);
            obj.set_taborder("2");
            obj.set_text("기입 :");
            obj.set_textAlign("center");
            obj.set_border("0px none");
            this.menuForm.form.Tab00.csManage.form.Div00.addChild(obj.name, obj);

            obj = new Edit("Edit02","473","299","413","120",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form.Div00.form);
            obj.set_taborder("3");
            obj.set_border("1px solid #c1c1c1");
            this.menuForm.form.Tab00.csManage.form.Div00.addChild(obj.name, obj);

            obj = new Edit("Edit02_00","542","129","344","35",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form.Div00.form);
            obj.set_taborder("4");
            obj.set_border("1px solid #c1c1c1");
            this.menuForm.form.Tab00.csManage.form.Div00.addChild(obj.name, obj);

            obj = new Button("btn_search","473","15","90","30",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form.Div00.form);
            obj.set_taborder("5");
            obj.set_text("찾기");
            obj.set_cssclass("btn_default");
            this.menuForm.form.Tab00.csManage.form.Div00.addChild(obj.name, obj);

            obj = new Static("Static01","473","67","413","40",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form.Div00.form);
            obj.set_taborder("6");
            obj.set_text("답장 쓰기");
            obj.set_textAlign("center");
            obj.set_font("14px");
            obj.set_cssclass("sta_default");
            this.menuForm.form.Tab00.csManage.form.Div00.addChild(obj.name, obj);

            obj = new Static("Static01_00","9","67","420","40",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form.Div00.form);
            obj.set_taborder("7");
            obj.set_text("목록 보기");
            obj.set_textAlign("center");
            obj.set_cssclass("sta_default");
            obj.set_font("14px/normal \"Magun Gothic\"");
            this.menuForm.form.Tab00.csManage.form.Div00.addChild(obj.name, obj);

            obj = new Static("Static02","440","309","39","35",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form.Div00.form);
            obj.set_taborder("8");
            obj.set_text("Re : ");
            this.menuForm.form.Tab00.csManage.form.Div00.addChild(obj.name, obj);

            obj = new Grid("Grid00","9","125","421","294",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form.Div00.form);
            obj.set_taborder("9");
            obj.set_binddataset("ds_service");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"40\"/><Column size=\"51\"/><Column size=\"62\"/><Column size=\"144\"/><Column size=\"124\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell displaytype=\"none\" edittype=\"none\"/><Cell col=\"1\" text=\"seq\"/><Cell col=\"2\" text=\"writer\"/><Cell col=\"3\" text=\"title\"/><Cell col=\"4\" text=\"write_date\"/></Band><Band id=\"body\"><Cell text=\"bind:chk\" displaytype=\"checkboxcontrol\" edittype=\"checkbox\"/><Cell col=\"1\" text=\"bind:seq\"/><Cell col=\"2\" text=\"bind:writer\"/><Cell col=\"3\" text=\"bind:title\"/><Cell col=\"4\" text=\"bind:write_date\"/></Band></Format></Formats>");
            this.menuForm.form.Tab00.csManage.form.Div00.addChild(obj.name, obj);

            obj = new Static("Static02_00","473","129","59","35",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form.Div00.form);
            obj.set_taborder("10");
            obj.set_text("Title : ");
            this.menuForm.form.Tab00.csManage.form.Div00.addChild(obj.name, obj);

            obj = new Edit("Edit01","473","184","413","110",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form.Div00.form);
            obj.set_taborder("11");
            obj.set_border("1px solid #c1c1c1");
            this.menuForm.form.Tab00.csManage.form.Div00.addChild(obj.name, obj);

            obj = new Combo("cb_search","64","15","130","30",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form.Div00.form);
            obj.set_taborder("12");
            obj.set_innerdataset("ds_combo");
            obj.set_codecolumn("id");
            obj.set_datacolumn("name");
            obj.set_text("Combo00");
            this.menuForm.form.Tab00.csManage.form.Div00.addChild(obj.name, obj);

            obj = new Button("btn_Upd","807","506","100","40",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form);
            obj.set_taborder("1");
            obj.set_text("확정");
            obj.set_cssclass("btn_default");
            this.menuForm.form.Tab00.csManage.addChild(obj.name, obj);

            obj = new Button("btn_Del","559","506","100","40",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form);
            obj.set_taborder("2");
            obj.set_text("삭제");
            obj.set_cssclass("btn_white");
            obj.set_borderRadius("5px");
            obj.set_font("12px \"Malgun Gothic\"");
            this.menuForm.form.Tab00.csManage.addChild(obj.name, obj);

            obj = new Button("btn_retrive","683","506","100","40",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form);
            obj.set_taborder("3");
            obj.set_text("갱신");
            obj.set_cssclass("btn_default");
            this.menuForm.form.Tab00.csManage.addChild(obj.name, obj);

            obj = new Static("Static00","25","23","250","50",null,null,null,null,null,null,this.menuForm.form.Tab00.csManage.form);
            obj.set_taborder("4");
            obj.set_text("문의사항 관리");
            obj.set_cssclass("sta_title");
            this.menuForm.form.Tab00.csManage.addChild(obj.name, obj);

            obj = new Tabpage("memManage",this.menuForm.form.Tab00);
            obj.set_text("회원관리");
            obj.set_border("1px solid black");
            this.menuForm.form.Tab00.addChild(obj.name, obj);

            obj = new Grid("Grid00","25","70","934","470",null,null,null,null,null,null,this.menuForm.form.Tab00.memManage.form);
            obj.set_taborder("0");
            obj.set_binddataset("ds_members");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/><Column size=\"80\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell displaytype=\"none\" edittype=\"none\"/><Cell col=\"1\" text=\"id\"/><Cell col=\"2\" text=\"pw\"/><Cell col=\"3\" text=\"email\"/><Cell col=\"4\" text=\"black_list\"/><Cell col=\"5\" text=\"admin\"/><Cell col=\"6\" text=\"mileage\"/><Cell col=\"7\" text=\"name\"/><Cell col=\"8\" text=\"contact\"/></Band><Band id=\"body\"><Cell text=\"bind:chk\" displaytype=\"checkboxcontrol\" edittype=\"checkbox\"/><Cell col=\"1\" text=\"bind:id\"/><Cell col=\"2\" text=\"bind:pw\"/><Cell col=\"3\" text=\"bind:email\"/><Cell col=\"4\" text=\"bind:black_list\"/><Cell col=\"5\" text=\"bind:admin\"/><Cell col=\"6\" text=\"bind:mileage\"/><Cell col=\"7\" text=\"bind:name\"/><Cell col=\"8\" text=\"bind:contact\"/></Band></Format></Formats>");
            this.menuForm.form.Tab00.memManage.addChild(obj.name, obj);

            obj = new Button("btnDel","859","549","100","40",null,null,null,null,null,null,this.menuForm.form.Tab00.memManage.form);
            obj.set_taborder("1");
            obj.set_text("회원탈퇴");
            obj.set_cssclass("btn_default");
            this.menuForm.form.Tab00.memManage.addChild(obj.name, obj);

            obj = new Static("Static00","25","18","250","50",null,null,null,null,null,null,this.menuForm.form.Tab00.memManage.form);
            obj.set_taborder("2");
            obj.set_text("회원관리");
            obj.set_cssclass("sta_title");
            this.menuForm.form.Tab00.memManage.addChild(obj.name, obj);

            obj = new Tabpage("Message",this.menuForm.form.Tab00);
            obj.set_text("알림 메시지");
            obj.set_border("1px solid black");
            this.menuForm.form.Tab00.addChild(obj.name, obj);

            obj = new Grid("MessageGrid","25","73","934","462",null,null,null,null,null,null,this.menuForm.form.Tab00.Message.form);
            obj.set_taborder("0");
            obj.set_binddataset("ds_member");
            obj.set_autofittype("col");
            obj._setContents("<Formats><Format id=\"default\"><Columns><Column size=\"55\"/><Column size=\"97\"/><Column size=\"101\"/><Column size=\"126\"/><Column size=\"171\"/><Column size=\"175\"/><Column size=\"103\"/><Column size=\"73\"/></Columns><Rows><Row size=\"24\" band=\"head\"/><Row size=\"24\"/></Rows><Band id=\"head\"><Cell displaytype=\"none\" edittype=\"none\" checkboxtruevalue=\"Y\" checkboxfalsevalue=\"N\"/><Cell col=\"1\" text=\"아이디\"/><Cell col=\"2\" text=\"성 명\"/><Cell col=\"3\" text=\"패스워드\"/><Cell col=\"4\" text=\"전화번호\"/><Cell col=\"5\" text=\"이메일\"/><Cell col=\"6\" text=\"마일리지\"/><Cell col=\"7\" text=\"블랙리스트\"/></Band><Band id=\"body\"><Cell text=\"bind:chk\" displaytype=\"checkboxcontrol\" edittype=\"checkbox\"/><Cell col=\"1\" text=\"bind:id\"/><Cell col=\"2\" text=\"bind:name\"/><Cell col=\"3\" text=\"bind:pw\"/><Cell col=\"4\" text=\"bind:contact\"/><Cell col=\"5\" text=\"bind:email\"/><Cell col=\"6\" text=\"bind:mileage\"/><Cell col=\"7\" text=\"bind:black_list\" displaytype=\"checkboxcontrol\" checkboxtruevalue=\"Y\" checkboxfalsevalue=\"N\"/></Band></Format></Formats>");
            this.menuForm.form.Tab00.Message.addChild(obj.name, obj);

            obj = new Button("btnSend","829","543","130","32",null,null,null,null,null,null,this.menuForm.form.Tab00.Message.form);
            obj.set_taborder("1");
            obj.set_text("쪽지 쓰기");
            obj.set_cssclass("btn_default");
            this.menuForm.form.Tab00.Message.addChild(obj.name, obj);

            obj = new Static("Static00","25","24","250","50",null,null,null,null,null,null,this.menuForm.form.Tab00.Message.form);
            obj.set_taborder("2");
            obj.set_text("알림 메세지");
            obj.set_cssclass("sta_title");
            this.menuForm.form.Tab00.Message.addChild(obj.name, obj);

            obj = new Button("btnLogOut","1030","24","122","30",null,null,null,null,null,null,this.menuForm.form);
            obj.set_taborder("1");
            obj.set_text("로그아웃");
            obj.set_cssclass("btn_default");
            this.menuForm.addChild(obj.name, obj);

            obj = new Static("Static00_00","205","524","25","25",null,null,null,null,null,null,this);
            obj.set_taborder("2");
            obj.set_text("Static00");
            obj.set_cssclass("sta_default");
            obj.set_visible("false");
            this.addChild(obj.name, obj);

            obj = new Static("Static00_00_00","1164","555","25","25",null,null,null,null,null,null,this);
            obj.set_taborder("3");
            obj.set_text("Static00");
            obj.set_cssclass("sta_default");
            obj.set_visible("false");
            this.addChild(obj.name, obj);

            // Layout Functions
            //-- Default Layout : this
            obj = new Layout("default","",1280,720,this,function(p){});
            this.addLayout(obj.name, obj);
            
            // BindItem Information
            obj = new BindItem("item0","menuForm.form.Tab00","accessibilityaction","Dataset00","name");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item1","menuForm.form.Tab00.blSelect.form.Div00.form.sta_con","text","ds_report","reportContents");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item2","menuForm.form.Tab00.blSelect.form.Div00.form.Static00_00_00_00","text","ds_report","goodSeq");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item3","menuForm.form.Tab00.blSelect.form.Div00.form.Edit00","value","ds_report","reportedUser");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item4","menuForm.form.Tab00.blSelect.form.Div00.form.Static01","text","ds_report","reportDate");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item5","menuForm.form.Tab00.blSelect.form.Div00.form.Edit01","value","ds_report","reportMemo");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item6","menuForm.form.Tab00.blSelect.form.Div00.form.Combo00","value","ds_report","reportCode");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item7","menuForm.form.Tab00.csManage.form.Div00.form.Edit02_00","value","ds_service","title");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item8","menuForm.form.Tab00.csManage.form.Div00.form.Edit01","value","ds_service","contents");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item9","menuForm.form.Tab00.csManage.form.Div00.form.Edit02","value","ds_service","answer");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item12","menuForm.form.Tab00.pdManage.form.Div00.form.image","text","ds_goods","goodImg");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item10","menuForm.form.Tab00.pdManage.form.Div00.form.edtName","value","ds_goods","goodName");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item11","menuForm.form.Tab00.pdManage.form.Div00.form.staWriter","text","ds_goods","goodWriter");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item13","menuForm.form.Tab00.pdManage.form.taDes","value","ds_goods","goodDes");
            this.addChild(obj.name, obj);
            obj.bind();

            obj = new BindItem("item14","menuForm.form.Tab00.pdManage.form.Div00.form.Combo00","value","ds_goods","cateCode");
            this.addChild(obj.name, obj);
            obj.bind();
        };
        
        this.loadPreloadList = function()
        {

        };
        
        // User Script
        this.registerScript("MenuFrame.xfdl", function() {


        this.menuForm_btnLogOut_onclick = function(obj,e)
        {
        	var objApp = nexacro.getApplication();
        	var id = nexacro.getPrivateProfile("id");
        	objApp.mainframe.VFrameSet00.LoginFrame.form.loginForm.form.loginBox.form.edtPW.set_value("");
        	objApp.mainframe.VFrameSet00.LoginFrame.form.loginForm.form.loginBox.form.chkLogin.set_value("");
        	if(id != undefined && id.length > 0){
        		objApp.mainframe.VFrameSet00.LoginFrame.form.loginForm.form.loginBox.form.edtID.set_value(id);
        		objApp.mainframe.VFrameSet00.LoginFrame.form.loginForm.form.loginBox.form.chkID.set_value(true);
        	}else{
        		objApp.mainframe.VFrameSet00.LoginFrame.form.loginForm.form.loginBox.form.edtID.set_value("");
        		objApp.mainframe.VFrameSet00.LoginFrame.form.loginForm.form.loginBox.form.chkID.set_value(false);
        	}
        	nexacro.setPrivateProfile("login","");
        	objApp.mainframe.VFrameSet00.set_separatesize("*,0");

        };

        this.fn_callback = function(id,ErrorCode,ErrorMsg)
        {
        	trace(ErrorMsg);
        }

        this.menuForm_Tab00_Message_btnSend_onclick = function(obj,e)
        {
        	let arr = this.ds_member.extractRows("chk==1");
        	let arrId ="";
        		if(arr.length == 0 || arr == -1)
        		{alert("선택된 항목이 없습니다");return;}
        		else{
        			for(var i =0; i<arr.length; i++){
        				var id = this.ds_member.getColumn(arr[i],"id");
        				arrId +=id +"/";
        			}

        			arrId=arrId.substring(0,arrId.length-1);
        			let x = this.width/2-400;
        			let y = this.height/2-300;
        			let objCF = new ChildFrame();
        			objCF.init("popAdd",x,y,800,600,0,0,"FrameBase::MsgPop.xfdl");
        			objCF.showModal(this.getOwnerFrame(),{param:arrId},this,"fn_pop_callback");
        		}
        };
        this.fn_pop_callback = function(sid,send){
        	if(send==null){return;}
        	let arr = send.split("|");
        	let ids = arr[0];
        	let id = ids.split("/");
        	let title = arr[1];
        	let contents = arr[2];
        	for(var i = 0; i<id.length; i++){
        			var nRow = this.ds_Msg.addRow();
        			this.ds_Msg.setColumn(nRow,"receiver",id[i]);
        			this.ds_Msg.setColumn(nRow,"title",title);
        			this.ds_Msg.setColumn(nRow,"contents",contents);
        			this.ds_Msg.setColumn(nRow,"sender","admin");
        	}
        	this.transaction(
        				"sendMsg"
        				,"/sendMsg.nex"
        				,"in_ds=ds_Msg:U"
        				,""
        				,""
        				,"fn_callback"
        			);
        	this.ds_Msg.deleteAll();
        }



        this.ds_blackList_oncolumnchanged = function(obj,e)
        {
        			this.transaction(
        				"blackList_update"
        				,"/blackListUpd.nex"
        				,"in_ds=ds_blackList:U"
        				,""
        				,""
        				,"fn_callback"
        			);
        };

        this.menuForm_Tab00_pdManage_btnDel_onclick = function(obj,e)
        {
        	let arr = this.ds_goods.extractRows("chk==1");
        	if(this.ds_goods.getRowCount() > 0){
        		if(arr.length == 0 || arr == -1)
        		{
        		alert("선택된 항목이 없습니다");return;
        		}else{
        			this.ds_goods.deleteMultiRows(arr);
        			this.transaction(
        				"goodsList_delete"
        				,"/goodsListDel.nex"
        				,"in_ds=ds_goods:U"
        				,""
        				,""
        				,"fn_callback"
        			);
        		}
        	}else{alert("글이 없습니다");}
        };

        this.menuForm_Tab00_pdManage_btnSearch_onclick = function(obj,e)
        {	let cbValue = this.menuForm.form.Tab00.pdManage.form.filter.value;
        	let edtSearch = this.menuForm.form.Tab00.pdManage.form.edtSearch.text;
        	if(cbValue == 'goodSeq'){
        		this.ds_goods.filter(cbValue+"=='"+edtSearch+"'");
        	}else if(cbValue == 'goodName' || cbValue =='goodDes'){
        		this.ds_goods.filter(cbValue+".indexOf('"+edtSearch+"')>=0");
        	}else{
        		alert("선택된 항목이 없습니다");
        	}
        };

        this.menuForm_Tab00_pdManage_Grid00_onheadclick = function(obj,e)
        {
        	if(e.cell==0){
              let flag = obj.getCellProperty("Head",0,"text");
              let check = flag==0?1:0;
              obj.setCellProperty("Head",0,"text",check);
              for(let i=0;i<this.ds_goods.rowcount;i++){
                 this.ds_goods.setColumn(i,0,check);
              }
           }
        };

        this.ds_goods_oncolumnchanged = function(obj,e)
        {
        				this.transaction(
        				"goodsList_update"
        				,"/goodsListUpd.nex"
        				,"in_ds=ds_goods:U"
        				,""
        				,""
        				,"fn_callback"
        				);
        };
        this.menuForm_Tab00_pdManage_reset_onclick = function(obj,e)
        {
        	this.ds_goods.filter("");
        };
        //---------------------------------------------------------------------^용--------------------------------------------------------------------




        this.fn_callback = function(id,ErrorCode,ErrorMsg)
        {
        	trace(ErrorMsg);
        }



        this.menuForm_Tab00_blSelect_Div00_btn_reportMemo_onclick = function(obj,e)
        {
        	this.transaction(
        		"reportMemoList",//id
        		"/report/updateMemo.nex",//url (절대경로)
        		"in_ds=ds_report:U",//in_ds:U
        		"",//()_out_ds
        		"",//argument
        		"fn_callback"
        		)
        };


        //-------------------------------------------------------------^현-------------------------------------------------------------------------




        this.fn_callback = function(id,ErrorCode,ErrorMsg){
        	trace(id);
        	trace(ErrorCode);
        	trace(ErrorMsg);
        }

        this.MenuFrame_onload = function(obj,e)
        {
        	this.transaction(
        			"ds_members", // 1. strSvcID
        			"/members/selectMembers.mem", // 2. strURL(절대경로로 입력해주어야함. 로컬호스트 뒤에는 이클립스 서버파일에 있는 path값)
        			"", // 3. strInDatasets - Sds=Fds:U, :A, :N
        			"ds_members=out_ds", // 4. strOutDatasets - select Fds = Sds
        			"", // 5. strArgument
        			"fn_callback" // 6. strCallbackFunc
        			);
        };

        this.menuForm_Tab00_memManage_btnDel_onclick = function(obj,e)
        {
        	let arr = this.ds_members.extractRows("check==1");
        	if(arr.length==0||arr==-1){alert("선택된 항목이 없습니다."); return;}
        	this.ds_members.deleteMultiRows(arr);

        	this.transaction(
        		"dsDel", // 1. strSvcID
        		"/members/dsDel.mem", // 2. strURL(절대경로로 입력해주어야함. 로컬호스트 뒤에는 이클립스 서버파일에 있는 path값)
        		"in_ds=ds_members:U", // 3. strInDatasets - Sds=Fds:U, :A, :N
        		"", // 4. strOutDatasets - select Fds = Sds
        		"", // 5. strArgument
        		"fn_callback" // 6. strCallbackFunc
        	);
        };

        this.menuForm_Tab00_memManage_Grid00_onheadclick = function(obj,e)
        {
        	if(e.cell==2){
        		let flag = obj.getCellProperty("Head",0,"text");
        		let check = flag==0?1:0;
        		obj.setCellProperty("Head",0,"text",check);
        		for(let i=0;i<this.ds_members.rowcount;i++){
        			this.ds_members.setColumn(i,0,check);
        		}
        	}
        };


        //--------------------------------------------------------^윤----------------------------------------------------------------------------


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


        this.MenuFrame_onload = function(obj,e)	//온로드
        {
        	this.transaction(
        			"ds_Load" //id
        			,"/cr/dsLoad.nex"//url
        			,""// inData
        			,"ds_service=out_ds"// outData
        			,""//strArg
        			,"fn_callback"//callback
        		);

        		//-----------------------------^민--------------------------------
        		this.transaction(
        			"ds_members", // 1. strSvcID
        			"/members/selectMembers.mem", // 2. strURL(절대경로로 입력해주어야함. 로컬호스트 뒤에는 이클립스 서버파일에 있는 path값)
        			"", // 3. strInDatasets - Sds=Fds:U, :A, :N
        			"ds_members=out_ds", // 4. strOutDatasets - select Fds = Sds
        			"", // 5. strArgument
        			"fn_callback" // 6. strCallbackFunc
        			);

        			//-----------------------------^윤--------------------------------
        			this.transaction(
        				"blackList"
        				,"/blackList.nex"
        				,""
        				,"ds_blackList=out_ds"
        				,""
        				,"fn_callback"
        			);
        			this.transaction(
        				"memberList"
        				,"/memberList.nex"
        				,""
        				,"ds_member=out_ds"
        				,""
        				,"fn_callback"
        			);
        			this.transaction(
        				"goodsList"
        				,"/goodsList.nex"
        				,""
        				,"ds_goods=out_ds"
        				,""
        				,"fn_callback"
        			)
        			//-----------------------------^용--------------------------------
        			this.transaction(
        				"reportList"
        				,"/report/reportList.nex"
        				,""
        				,"ds_report=out_ds"
        				,""
        				,"fn_callback"
        			);

        			//-----------------------------^현--------------------------------


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




        //-------------------------------------------------------------------------^민-----------------------------------------------







        });
        
        // Regist UI Components Event
        this.on_initEvent = function()
        {
            this.addEventHandler("onload",this.MenuFrame_onload,this);
            this.menuForm.form.Tab00.addEventHandler("onchanged",this.menuForm_Tab00_onchanged,this);
            this.menuForm.form.Tab00.blManage.form.blackListGrid.addEventHandler("onheadclick",this.menuForm_Tab00_blManage_blackListGrid_onheadclick,this);
            this.menuForm.form.Tab00.blSelect.form.Div00.form.Static00_00_00_01_00_01.addEventHandler("onclick",this.menuForm_Tab00_blSelect_Div00_Static00_00_00_01_00_01_onclick,this);
            this.menuForm.form.Tab00.blSelect.form.Div00.form.btn_reportMemo.addEventHandler("onclick",this.menuForm_Tab00_blSelect_Div00_btn_reportMemo_onclick,this);
            this.menuForm.form.Tab00.pdManage.form.Grid00.addEventHandler("onheadclick",this.menuForm_Tab00_pdManage_Grid00_onheadclick,this);
            this.menuForm.form.Tab00.pdManage.form.btnDel.addEventHandler("onclick",this.menuForm_Tab00_pdManage_btnDel_onclick,this);
            this.menuForm.form.Tab00.pdManage.form.btnSearch.addEventHandler("onclick",this.menuForm_Tab00_pdManage_btnSearch_onclick,this);
            this.menuForm.form.Tab00.pdManage.form.reset.addEventHandler("onclick",this.menuForm_Tab00_pdManage_reset_onclick,this);
            this.menuForm.form.Tab00.csManage.form.Div00.form.btn_search.addEventHandler("onclick",this.Div00_btn_search_onclick,this);
            this.menuForm.form.Tab00.csManage.form.Div00.form.Grid00.addEventHandler("onheadclick",this.Div00_Grid00_onheadclick,this);
            this.menuForm.form.Tab00.csManage.form.btn_Upd.addEventHandler("onclick",this.btn_Upd_onclick,this);
            this.menuForm.form.Tab00.csManage.form.btn_Del.addEventHandler("onclick",this.btn_Del_onclick,this);
            this.menuForm.form.Tab00.csManage.form.btn_retrive.addEventHandler("onclick",this.btn_retrive_onclick,this);
            this.menuForm.form.Tab00.memManage.form.Grid00.addEventHandler("onheadclick",this.menuForm_Tab00_memManage_Grid00_onheadclick,this);
            this.menuForm.form.Tab00.memManage.form.btnDel.addEventHandler("onclick",this.menuForm_Tab00_memManage_btnDel_onclick,this);
            this.menuForm.form.Tab00.Message.form.MessageGrid.addEventHandler("onheadclick",this.menuForm_Tab00_Message_MessageGrid_onheadclick,this);
            this.menuForm.form.Tab00.Message.form.btnSend.addEventHandler("onclick",this.menuForm_Tab00_Message_btnSend_onclick,this);
            this.menuForm.form.btnLogOut.addEventHandler("onclick",this.menuForm_btnLogOut_onclick,this);
            this.ds_blackList.addEventHandler("oncolumnchanged",this.ds_blackList_oncolumnchanged,this);
            this.ds_member00.addEventHandler("oncolumnchanged",this.ds_member_oncolumnchanged,this);
            this.ds_goods.addEventHandler("oncolumnchanged",this.ds_goods_oncolumnchanged,this);
        };

        this.loadIncludeScript("MenuFrame.xfdl");
        this.loadPreloadList();
        
        // Remove Reference
        obj = null;
    };
}
)();
