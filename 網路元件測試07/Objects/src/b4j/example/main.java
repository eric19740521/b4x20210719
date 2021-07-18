package b4j.example;


import anywheresoftware.b4a.BA;

public class main extends javafx.application.Application{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4j.objects.FxBA("b4j.example", "b4j.example.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "b4j.example.main", ba);
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}

 
    public static void main(String[] args) {
    	launch(args);
    }
    public void start (javafx.stage.Stage stage) {
        try {
            if (!false)
                System.setProperty("prism.lcdtext", "false");
            anywheresoftware.b4j.objects.FxBA.application = this;
		    anywheresoftware.b4a.keywords.Common.setDensity(javafx.stage.Screen.getPrimary().getDpi());
            anywheresoftware.b4a.keywords.Common.LogDebug("Program started.");
            initializeProcessGlobals();
            anywheresoftware.b4j.objects.Form frm = new anywheresoftware.b4j.objects.Form();
            frm.initWithStage(ba, stage, 600, 400);
            ba.raiseEvent(null, "appstart", frm, (String[])getParameters().getRaw().toArray(new String[0]));
        } catch (Throwable t) {
            BA.printException(t, true);
            System.exit(1);
        }
    }
public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.objects.JFX _fx = null;
public static anywheresoftware.b4j.objects.Form _mainform = null;
public static anywheresoftware.b4a.randomaccessfile.B4XSerializator _ser = null;
public static anywheresoftware.b4j.objects.ButtonWrapper _btnsend = null;
public static anywheresoftware.b4j.objects.ButtonWrapper _btnconnect = null;
public static boolean _connected = false;
public static anywheresoftware.b4a.objects.SocketWrapper _client = null;
public static anywheresoftware.b4a.objects.SocketWrapper.ServerSocketWrapper _server = null;
public static anywheresoftware.b4a.randomaccessfile.AsyncStreams _astream = null;
public static int _port = 0;
public static boolean _working = false;
public static anywheresoftware.b4j.objects.LabelWrapper _lblstatus = null;
public static anywheresoftware.b4j.objects.LabelWrapper _lblmyip = null;
public static anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper _edtname = null;
public static anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper _edtage = null;
public static anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper _edtip = null;
public static anywheresoftware.b4j.objects.CanvasWrapper _cvs = null;
public static anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper _textarea1 = null;
public static class _mymessage{
public boolean IsInitialized;
public String Name;
public int Age;
public byte[] Image;
public void Initialize() {
IsInitialized = true;
Name = "";
Age = 0;
Image = new byte[0];
;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static String  _appstart(anywheresoftware.b4j.objects.Form _form1,String[] _args) throws Exception{
 //BA.debugLineNum = 28;BA.debugLine="Sub AppStart (Form1 As Form, Args() As String)";
 //BA.debugLineNum = 29;BA.debugLine="MainForm = Form1";
_mainform = _form1;
 //BA.debugLineNum = 30;BA.debugLine="MainForm.RootPane.LoadLayout(\"1\") 'Load the layou";
_mainform.getRootPane().LoadLayout(ba,"1");
 //BA.debugLineNum = 31;BA.debugLine="MainForm.Show";
_mainform.Show();
 //BA.debugLineNum = 32;BA.debugLine="cvs.DrawRect(0, 0, cvs.Width, cvs.Height, fx.Colo";
_cvs.DrawRect(0,0,_cvs.getWidth(),_cvs.getHeight(),_fx.Colors.White,anywheresoftware.b4a.keywords.Common.True,0);
 //BA.debugLineNum = 33;BA.debugLine="server.Initialize(PORT, \"server\")";
_server.Initialize(ba,_port,"server");
 //BA.debugLineNum = 34;BA.debugLine="ListenForConnections";
_listenforconnections();
 //BA.debugLineNum = 35;BA.debugLine="UpdateState(False)";
_updatestate(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public static String  _astream_error() throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Sub AStream_Error";
 //BA.debugLineNum = 61;BA.debugLine="UpdateState(False)";
_updatestate(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _astream_newdata(byte[] _buffer) throws Exception{
b4j.example.main._mymessage _mm = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
anywheresoftware.b4j.objects.ImageViewWrapper.ImageWrapper _bmp = null;
 //BA.debugLineNum = 81;BA.debugLine="Sub AStream_NewData (Buffer() As Byte)";
 //BA.debugLineNum = 82;BA.debugLine="Dim mm As MyMessage = ser.ConvertBytesToObject(Bu";
_mm = (b4j.example.main._mymessage)(_ser.ConvertBytesToObject(_buffer));
 //BA.debugLineNum = 83;BA.debugLine="edtAge.Text = mm.Age";
_edtage.setText(BA.NumberToString(_mm.Age /*int*/ ));
 //BA.debugLineNum = 84;BA.debugLine="edtName.Text = mm.Name";
_edtname.setText(_mm.Name /*String*/ );
 //BA.debugLineNum = 86;BA.debugLine="Dim in As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
 //BA.debugLineNum = 87;BA.debugLine="in.InitializeFromBytesArray(mm.Image, 0, mm.Image";
_in.InitializeFromBytesArray(_mm.Image /*byte[]*/ ,(int) (0),_mm.Image /*byte[]*/ .length);
 //BA.debugLineNum = 88;BA.debugLine="Dim bmp As Image";
_bmp = new anywheresoftware.b4j.objects.ImageViewWrapper.ImageWrapper();
 //BA.debugLineNum = 89;BA.debugLine="bmp.Initialize2(in)";
_bmp.Initialize2((java.io.InputStream)(_in.getObject()));
 //BA.debugLineNum = 91;BA.debugLine="cvs.DrawImage(bmp, 0, 0, cvs.Width, cvs.Height)";
_cvs.DrawImage((javafx.scene.image.Image)(_bmp.getObject()),0,0,_cvs.getWidth(),_cvs.getHeight());
 //BA.debugLineNum = 94;BA.debugLine="TextArea1.Text = TextArea1.Text & \"訊息內容 =\"& mm.Na";
_textarea1.setText(_textarea1.getText()+"訊息內容 ="+_mm.Name /*String*/ +","+BA.NumberToString(_mm.Age /*int*/ )+anywheresoftware.b4a.keywords.Common.CRLF);
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return "";
}
public static String  _astream_terminated() throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Sub AStream_Terminated";
 //BA.debugLineNum = 65;BA.debugLine="UpdateState(False)";
_updatestate(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
public static String  _btnconnect_action() throws Exception{
 //BA.debugLineNum = 133;BA.debugLine="Sub btnConnect_Action";
 //BA.debugLineNum = 134;BA.debugLine="If connected = False Then";
if (_connected==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 135;BA.debugLine="If edtIP.Text.Length = 0 Then";
if (_edtip.getText().length()==0) { 
 //BA.debugLineNum = 136;BA.debugLine="fx.Msgbox(MainForm, \"Please enter the server ip";
_fx.Msgbox(_mainform,"Please enter the server ip address.","");
 //BA.debugLineNum = 137;BA.debugLine="Return";
if (true) return "";
 }else {
 //BA.debugLineNum = 139;BA.debugLine="ConnectToServer(edtIP.Text)";
_connecttoserver(_edtip.getText());
 };
 }else {
 //BA.debugLineNum = 142;BA.debugLine="Disconnect";
_disconnect();
 };
 //BA.debugLineNum = 144;BA.debugLine="End Sub";
return "";
}
public static String  _btnsend_action() throws Exception{
b4j.example.main._mymessage _mm = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
 //BA.debugLineNum = 146;BA.debugLine="Sub btnSend_Action";
 //BA.debugLineNum = 147;BA.debugLine="Dim mm As MyMessage";
_mm = new b4j.example.main._mymessage();
 //BA.debugLineNum = 148;BA.debugLine="mm.Initialize";
_mm.Initialize();
 //BA.debugLineNum = 149;BA.debugLine="If IsNumber(edtAge.Text) Then mm.Age = edtAge.Tex";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_edtage.getText())) { 
_mm.Age /*int*/  = (int)(Double.parseDouble(_edtage.getText()));}
else {
_mm.Age /*int*/  = (int) (0);};
 //BA.debugLineNum = 150;BA.debugLine="mm.Name = edtName.Text";
_mm.Name /*String*/  = _edtname.getText();
 //BA.debugLineNum = 152;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
 //BA.debugLineNum = 153;BA.debugLine="out.InitializeToBytesArray(0)";
_out.InitializeToBytesArray((int) (0));
 //BA.debugLineNum = 154;BA.debugLine="cvs.Snapshot.WriteToStream(out)";
_cvs.Snapshot().WriteToStream((java.io.OutputStream)(_out.getObject()));
 //BA.debugLineNum = 155;BA.debugLine="out.Close";
_out.Close();
 //BA.debugLineNum = 156;BA.debugLine="mm.Image = out.ToBytesArray";
_mm.Image /*byte[]*/  = _out.ToBytesArray();
 //BA.debugLineNum = 157;BA.debugLine="SendData (ser.ConvertObjectToBytes(mm))";
_senddata(_ser.ConvertObjectToBytes((Object)(_mm)));
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
return "";
}
public static String  _closeexistingconnection() throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Sub CloseExistingConnection";
 //BA.debugLineNum = 55;BA.debugLine="If astream.IsInitialized Then astream.Close";
if (_astream.IsInitialized()) { 
_astream.Close();};
 //BA.debugLineNum = 56;BA.debugLine="If client.IsInitialized Then client.Close";
if (_client.IsInitialized()) { 
_client.Close();};
 //BA.debugLineNum = 57;BA.debugLine="UpdateState (False)";
_updatestate(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public static void  _connecttoserver(String _host) throws Exception{
ResumableSub_ConnectToServer rsub = new ResumableSub_ConnectToServer(null,_host);
rsub.resume(ba, null);
}
public static class ResumableSub_ConnectToServer extends BA.ResumableSub {
public ResumableSub_ConnectToServer(b4j.example.main parent,String _host) {
this.parent = parent;
this._host = _host;
}
b4j.example.main parent;
String _host;
boolean _successful = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 106;BA.debugLine="Log(\"Trying to connect to: \" & Host)";
anywheresoftware.b4a.keywords.Common.Log("Trying to connect to: "+_host);
 //BA.debugLineNum = 107;BA.debugLine="CloseExistingConnection";
_closeexistingconnection();
 //BA.debugLineNum = 108;BA.debugLine="Dim client As Socket";
parent._client = new anywheresoftware.b4a.objects.SocketWrapper();
 //BA.debugLineNum = 109;BA.debugLine="client.Initialize(\"client\")";
parent._client.Initialize("client");
 //BA.debugLineNum = 110;BA.debugLine="client.Connect(Host, PORT, 10000)";
parent._client.Connect(ba,_host,parent._port,(int) (10000));
 //BA.debugLineNum = 111;BA.debugLine="Wait For Client_Connected (Successful As Boolean)";
anywheresoftware.b4a.keywords.Common.WaitFor("client_connected", ba, this, null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_successful = (boolean) result[0];
;
 //BA.debugLineNum = 112;BA.debugLine="If Successful Then";
if (true) break;

case 1:
//if
this.state = 6;
if (_successful) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 //BA.debugLineNum = 113;BA.debugLine="astream.InitializePrefix(client.InputStream, Fal";
parent._astream.InitializePrefix(ba,parent._client.getInputStream(),anywheresoftware.b4a.keywords.Common.False,parent._client.getOutputStream(),"astream");
 //BA.debugLineNum = 114;BA.debugLine="UpdateState (True)";
_updatestate(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 116;BA.debugLine="Log(\"Failed to connect: \" & LastException)";
anywheresoftware.b4a.keywords.Common.Log("Failed to connect: "+BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(ba)));
 if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 118;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _client_connected(boolean _successful) throws Exception{
}
public static String  _cvs_mousedragged(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
 //BA.debugLineNum = 129;BA.debugLine="Sub cvs_MouseDragged (EventData As MouseEvent)";
 //BA.debugLineNum = 130;BA.debugLine="cvs.DrawCircle(EventData.X, EventData.Y, 30dip, f";
_cvs.DrawCircle(_eventdata.getX(),_eventdata.getY(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),(javafx.scene.paint.Paint)(_fx.Colors.From32Bit(anywheresoftware.b4a.keywords.Common.Rnd((int) (0xff000000),(int) (-1)))),anywheresoftware.b4a.keywords.Common.True,0);
 //BA.debugLineNum = 131;BA.debugLine="End Sub";
return "";
}
public static String  _disconnect() throws Exception{
 //BA.debugLineNum = 120;BA.debugLine="Private Sub Disconnect";
 //BA.debugLineNum = 121;BA.debugLine="CloseExistingConnection";
_closeexistingconnection();
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return "";
}
public static void  _listenforconnections() throws Exception{
ResumableSub_ListenForConnections rsub = new ResumableSub_ListenForConnections(null);
rsub.resume(ba, null);
}
public static class ResumableSub_ListenForConnections extends BA.ResumableSub {
public ResumableSub_ListenForConnections(b4j.example.main parent) {
this.parent = parent;
}
b4j.example.main parent;
boolean _successful = false;
anywheresoftware.b4a.objects.SocketWrapper _newsocket = null;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 39;BA.debugLine="Do While working";
if (true) break;

case 1:
//do while
this.state = 8;
while (parent._working) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 40;BA.debugLine="server.Listen";
parent._server.Listen();
 //BA.debugLineNum = 41;BA.debugLine="Wait For Server_NewConnection (Successful As Boo";
anywheresoftware.b4a.keywords.Common.WaitFor("server_newconnection", ba, this, null);
this.state = 9;
return;
case 9:
//C
this.state = 4;
_successful = (boolean) result[0];
_newsocket = (anywheresoftware.b4a.objects.SocketWrapper) result[1];
;
 //BA.debugLineNum = 42;BA.debugLine="If Successful Then";
if (true) break;

case 4:
//if
this.state = 7;
if (_successful) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 43;BA.debugLine="CloseExistingConnection";
_closeexistingconnection();
 //BA.debugLineNum = 44;BA.debugLine="client = NewSocket";
parent._client = _newsocket;
 //BA.debugLineNum = 45;BA.debugLine="astream.InitializePrefix(client.InputStream, Fa";
parent._astream.InitializePrefix(ba,parent._client.getInputStream(),anywheresoftware.b4a.keywords.Common.False,parent._client.getOutputStream(),"astream");
 //BA.debugLineNum = 46;BA.debugLine="UpdateState(True)";
_updatestate(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 48;BA.debugLine="TextArea1.Text = TextArea1.Text & \"遠端IP =\"& New";
parent._textarea1.setText(parent._textarea1.getText()+"遠端IP ="+_newsocket.getRemoteAddress()+anywheresoftware.b4a.keywords.Common.CRLF);
 if (true) break;

case 7:
//C
this.state = 1;
;
 if (true) break;

case 8:
//C
this.state = -1;
;
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _server_newconnection(boolean _successful,anywheresoftware.b4a.objects.SocketWrapper _newsocket) throws Exception{
}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Private fx As JFX";
_fx = new anywheresoftware.b4j.objects.JFX();
 //BA.debugLineNum = 8;BA.debugLine="Private MainForm As Form";
_mainform = new anywheresoftware.b4j.objects.Form();
 //BA.debugLineNum = 9;BA.debugLine="Private ser As B4XSerializator";
_ser = new anywheresoftware.b4a.randomaccessfile.B4XSerializator();
 //BA.debugLineNum = 10;BA.debugLine="Type MyMessage (Name As String, Age As Int, Image";
;
 //BA.debugLineNum = 11;BA.debugLine="Private btnSend As Button";
_btnsend = new anywheresoftware.b4j.objects.ButtonWrapper();
 //BA.debugLineNum = 12;BA.debugLine="Private btnConnect As Button";
_btnconnect = new anywheresoftware.b4j.objects.ButtonWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private connected As Boolean";
_connected = false;
 //BA.debugLineNum = 14;BA.debugLine="Private client As Socket";
_client = new anywheresoftware.b4a.objects.SocketWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Public server As ServerSocket";
_server = new anywheresoftware.b4a.objects.SocketWrapper.ServerSocketWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private astream As AsyncStreams";
_astream = new anywheresoftware.b4a.randomaccessfile.AsyncStreams();
 //BA.debugLineNum = 17;BA.debugLine="Private const PORT As Int = 5500";
_port = (int) (5500);
 //BA.debugLineNum = 18;BA.debugLine="Private working As Boolean = True";
_working = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 19;BA.debugLine="Private lblStatus As Label";
_lblstatus = new anywheresoftware.b4j.objects.LabelWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private lblMyIp As Label";
_lblmyip = new anywheresoftware.b4j.objects.LabelWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private edtName As TextField";
_edtname = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private edtAge As TextField";
_edtage = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private edtIP As TextField";
_edtip = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private cvs As Canvas";
_cvs = new anywheresoftware.b4j.objects.CanvasWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private TextArea1 As TextArea";
_textarea1 = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper();
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return "";
}
public static String  _senddata(byte[] _data) throws Exception{
 //BA.debugLineNum = 125;BA.debugLine="Public Sub SendData (data() As Byte)";
 //BA.debugLineNum = 126;BA.debugLine="If connected Then astream.Write(data)";
if (_connected) { 
_astream.Write(_data);};
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public static String  _updatestate(boolean _newstate) throws Exception{
 //BA.debugLineNum = 67;BA.debugLine="Sub UpdateState (NewState As Boolean)";
 //BA.debugLineNum = 68;BA.debugLine="connected = NewState";
_connected = _newstate;
 //BA.debugLineNum = 69;BA.debugLine="btnSend.Enabled = connected";
_btnsend.setEnabled(_connected);
 //BA.debugLineNum = 70;BA.debugLine="If connected Then";
if (_connected) { 
 //BA.debugLineNum = 71;BA.debugLine="btnConnect.Text = \"Disconnect\"";
_btnconnect.setText("Disconnect");
 //BA.debugLineNum = 72;BA.debugLine="lblStatus.Text = \"Connected\"";
_lblstatus.setText("Connected");
 }else {
 //BA.debugLineNum = 74;BA.debugLine="btnConnect.Text = \"Connect\"";
_btnconnect.setText("Connect");
 //BA.debugLineNum = 75;BA.debugLine="lblStatus.Text = \"Disconnected\"";
_lblstatus.setText("Disconnected");
 };
 //BA.debugLineNum = 77;BA.debugLine="lblMyIp.Text = \"My ip: \" & server.GetMyIP";
_lblmyip.setText("My ip: "+_server.GetMyIP());
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
}
