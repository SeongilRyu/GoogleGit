<%
  Dim oXMLHTTP
  Dim strStatusTest
  Set oXMLHTTP = CreateObject("MSXML2.ServerXMLHTTP.3.0")
  oXMLHTTP.Open "GET", "http://pbmining.com", False
  oXMLHTTP.Send
  If oXMLHTTP.Status = 200 Then
    response.write(oXMLHTTP.responseText)

  End If
  
%>

