<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page import="java.util.List"%>
<html class="supernova"><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="HandheldFriendly" content="true" / -->
<title>Form</title>
<style type="text/css">
    .form-label-left{
        width:150px !important;
    }
    .form-line{
        padding-top:12px;
        padding-bottom:12px;
    }
    .form-label-right{
        width:150px !important;
    }
    body, html{
        margin:0;
        padding:0;
        background:false;
    }

    .form-all{
        margin:0px auto;
        padding-top:0px;
        width:650px;
        color:#555 !important;
        font-family:"Lucida Grande", "Lucida Sans Unicode", "Lucida Sans", Verdana, sans-serif;
        font-size:16px;
    }
    .form-radio-item label, .form-checkbox-item label, .form-grading-label, .form-header{
        color: #555;
    }

</style>

<style type="text/css" id="form-designer-style">
    /* Injected CSS Code */
.form-all {
  font-family: "Lucida Grande", sans-serif;
}
.form-all {
  width: 650px;
}
.form-label-left,
.form-label-right {
  width: 150px;
}
.form-label {
  white-space: normal;
}
.form-label.form-label-auto {
  display: inline-block;
  float: left;
  text-align: left;
  width: 150px;
}
.form-label-left {
  display: inline-block;
  white-space: normal;
  float: left;
  text-align: left;
}
.form-label-right {
  display: inline-block;
  white-space: normal;
  float: left;
  text-align: right;
}
.form-label-top {
  white-space: normal;
  display: block;
  float: none;
  text-align: left;
}
.form-all {
  font-size: 16px;
}
.form-label {
  font-weight: bold;
}
.form-checkbox-item label,
.form-radio-item label {
  font-weight: normal;
}
.supernova {
  background-color: #d5eef3;
  background-color: #69d2e7;
}
.supernova body {
  background-color: transparent;
}
/*
@width30: (unit(@formWidth, px) + 60px);
@width60: (unit(@formWidth, px)+ 120px);
@width90: (unit(@formWidth, px)+ 180px);
*/
/* | */
@media screen and (min-width: 480px) {
  .supernova .form-all {
    border: 1px solid #3dc5e0;
    -webkit-box-shadow: 0 3px 9px rgba(0, 0, 0, 0.1);
    -moz-box-shadow: 0 3px 9px rgba(0, 0, 0, 0.1);
    box-shadow: 0 3px 9px rgba(0, 0, 0, 0.1);
  }
}
/* | */
/* | */
@media screen and (max-width: 480px) {
  .jotform-form {
    padding: 10px 0;
  }
}
/* | */
/* | */
@media screen and (min-width: 480px) and (max-width: 768px) {
  .jotform-form {
    padding: 30px 0;
  }
}
/* | */
/* | */
@media screen and (min-width: 768px) and (max-width: 1024px) {
  .jotform-form {
    padding: 60px 0;
  }
}
/* | */
/* | */
@media screen and (min-width: 1024px) {
  .jotform-form {
    padding: 90px 0;
  }
}
/* | */
.supernova .form-all,
.form-all {
  background-color: #d5eef3;
  border: 1px solid transparent;
}
.form-header-group {
  border-color: #addee8;
}
.form-matrix-table tr {
  border-color: #addee8;
}
.form-matrix-table tr:nth-child(2n) {
  background-color: #c1e6ed;
}
.form-all {
  color: #3e4e1a;
}
.form-header-group .form-header {
  color: #3e4e1a;
}
.form-header-group .form-subHeader {
  color: #5c7427;
}
.form-sub-label {
  color: #5c7427;
}
.form-label-top,
.form-label-left,
.form-label-right,
.form-html {
  color: #3e4e1a;
}
.form-checkbox-item label,
.form-radio-item label {
  color: #5c7427;
}
.form-line.form-line-active {
  -webkit-transition-property: all;
  -moz-transition-property: all;
  -ms-transition-property: all;
  -o-transition-property: all;
  transition-property: all;
  -webkit-transition-duration: 0.3s;
  -moz-transition-duration: 0.3s;
  -ms-transition-duration: 0.3s;
  -o-transition-duration: 0.3s;
  transition-duration: 0.3s;
  -webkit-transition-timing-function: ease;
  -moz-transition-timing-function: ease;
  -ms-transition-timing-function: ease;
  -o-transition-timing-function: ease;
  transition-timing-function: ease;
  background-color: rgba(255, 255, 255, 0.75);
}
/* ömer */
.form-radio-item,
.form-checkbox-item {
  padding-bottom: 0px !important;
}
.form-radio-item:last-child,
.form-checkbox-item:last-child {
  padding-bottom: 0;
}
/* ömer */
.form-single-column .form-checkbox-item,
.form-single-column .form-radio-item {
  width: 100%;
}
.supernova {
  height: 100%;
  background-repeat: no-repeat;
  background-attachment: scroll;
  background-position: center top;
  background-repeat: repeat;
}
.supernova {
  background-image: none;
}
#stage {
  background-image: none;
}
/* | */
.form-all {
  background-repeat: no-repeat;
  background-attachment: scroll;
  background-position: center top;
  background-repeat: repeat;
}
.form-header-group {
  background-repeat: no-repeat;
  background-attachment: scroll;
  background-position: center top;
}
.form-line {
  margin-top: 12px;
  margin-bottom: 12px;
}
.form-line {
  padding: 12px 36px;
}
.form-all .qq-upload-button,
.form-all .form-submit-button,
.form-all .form-submit-reset,
.form-all .form-submit-print {
  font-size: 1em;
  padding: 9px 15px;
  font-family: "Lucida Grande", sans-serif;
  font-size: 16px;
  font-weight: normal;
}
.form-all .form-pagebreak-back,
.form-all .form-pagebreak-next {
  font-size: 1em;
  padding: 9px 15px;
  font-family: "Lucida Grande", sans-serif;
  font-size: 16px;
  font-weight: normal;
}
/*
&amp; when ( @buttonFontType = google ) {
	@import (css) "@{buttonFontLink}";
}
*/
h2.form-header {
  line-height: 1.618em;
  font-size: 1.714em;
}
h2 ~ .form-subHeader {
  line-height: 1.5em;
  font-size: 1.071em;
}
.form-header-group {
  text-align: left;
}
/*.form-dropdown,
.form-radio-item,
.form-checkbox-item,
.form-radio-other-input,
.form-checkbox-other-input,*/
.form-captcha input,
.form-spinner input,
.form-error-message {
  padding: 4px 3px 2px 3px;
}
.form-header-group {
  font-family: "Lucida Grande", sans-serif;
}
.form-section {
  padding: 0px 0px 0px 0px;
}
.form-header-group {
  margin: 12px 36px 12px 36px;
}
.form-header-group {
  padding: 24px 0px 24px 0px;
}
.form-textbox,
.form-textarea {
  padding: 4px 3px 2px 3px;
}
.form-textbox,
.form-textarea,
.form-radio-other-input,
.form-checkbox-other-input,
.form-captcha input,
.form-spinner input {
  background-color: #ffffff;
}
[data-type="control_dropdown"] .form-input,
[data-type="control_dropdown"] .form-input-wide {
  width: 150px;
}
.form-label {
  font-family: "Lucida Grande", sans-serif;
}
li[data-type="control_image"] div {
  text-align: left;
}
li[data-type="control_image"] img {
  border: none;
  border-width: 0px !important;
  border-style: solid !important;
  border-color: false !important;
}
.form-line-column {
  width: auto;
}
.form-line-error {
  overflow: hidden;
  -webkit-transition-property: none;
  -moz-transition-property: none;
  -ms-transition-property: none;
  -o-transition-property: none;
  transition-property: none;
  -webkit-transition-duration: 0.3s;
  -moz-transition-duration: 0.3s;
  -ms-transition-duration: 0.3s;
  -o-transition-duration: 0.3s;
  transition-duration: 0.3s;
  -webkit-transition-timing-function: ease;
  -moz-transition-timing-function: ease;
  -ms-transition-timing-function: ease;
  -o-transition-timing-function: ease;
  transition-timing-function: ease;
  background-color: #fff4f4;
}
.form-line-error .form-error-message {
  background-color: #ff3200;
  clear: both;
  float: none;
}
.form-line-error .form-error-message .form-error-arrow {
  border-bottom-color: #ff3200;
}
.form-line-error input:not(#coupon-input),
.form-line-error textarea,
.form-line-error .form-validation-error {
  border: 1px solid #ff3200;
  -webkit-box-shadow: 0 0 3px #ff3200;
  -moz-box-shadow: 0 0 3px #ff3200;
  box-shadow: 0 0 3px #ff3200;
}
.ie-8 .form-all {
  margin-top: auto;
  margin-top: initial;
}
.ie-8 .form-all:before {
  display: none;
}
/* | */
@media screen and (max-width: 480px), screen and (max-device-width: 768px) and (orientation: portrait), screen and (max-device-width: 415px) and (orientation: landscape) {
  .jotform-form {
    padding: 0;
  }
  .form-all {
    border: 0;
    width: 100%;
    max-width: initial;
  }
  .form-sub-label-container {
    width: 100%;
    margin: 0;
  }
  .form-input {
    width: 100%;
  }
  .form-label {
    width: 100%!important;
  }
  .form-line {
    padding: 2% 5%;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
  }
  input[type=text],
  input[type=email],
  input[type=tel],
  textarea {
    width: 100%;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    max-width: initial !important;
  }
  .form-input,
  .form-input-wide,
  .form-textarea,
  .form-textbox,
  .form-dropdown {
    max-width: initial !important;
  }
  div.form-header-group {
    padding: 24px 0px !important;
    margin: 0 12px 2% !important;
    margin-left: 5% !important;
    margin-right: 5% !important;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
  }
  [data-type="control_button"] {
    margin-bottom: 0 !important;
  }
  .form-buttons-wrapper {
    margin: 0!important;
  }
  .form-buttons-wrapper button {
    width: 100%;
  }
  table {
    width: 100%!important;
    max-width: initial !important;
  }
  table td + td {
    padding-left: 3%;
  }
  .form-checkbox-item input,
  .form-radio-item input {
    width: auto;
  }
  .form-collapse-table {
    margin: 0 5%;
  }
}
/* | */

/*__INSPECT_SEPERATOR__*/

    /* Injected CSS Code */
</style>

</head>
<body>

<form name="emailDigest" action="/TestProject/emaildigest/EmailDigest" method="post" onsubmit="return submitVerify();" accept-charset="utf-8">
  <input type="hidden" name="formID" value="51877219856167" />
  <div class="form-all">
    <ul class="form-section page-section">
    	<% 
			String status = (String)request.getAttribute("status");
			if(status!=null && !status.isEmpty()) {%>
				<center><label class="form-error-message" id="eventStatus" for="input_6">
				<% out.println("<b>"+status+"</b>");
				List<String> errors = (List<String>)request.getAttribute("errors");
				if(errors!=null && !errors.isEmpty()) {
					for (String err: errors) {
						out.println("<ul>" + err + "</ul>");
					}
				}
				%>
				</label></center>
			<% }
		%>
    
      <ul id="cid_10" class="form-input-wide" data-type="control_head">
        <div class="form-header-group">
          <div class="header-text httal htvam">
            <h2 id="header_10" class="form-header">
              EVENT EMAIL DIGEST
            </h2>
          </div>
        </div>
      </ul>
      
      <ul class="form-line" data-type="control_dropdown" id="id_6">
        <label class="form-label form-label-left form-label-auto" id="eventStatus" for="input_6"> Environment </label>
        <div id="cid_6" class="form-input jf-required">
          <select class="form-dropdown" style="width:150px" id="eventStatus" name="env">
            <option value="">  </option>
            <option value="QA"> QA </option>
            <option value="PROD"> PROD </option>
          </select>
        </div>
      </ul>
      <ul class="form-line" data-type="control_dropdown" id="id_3">
        <label class="form-label form-label-left form-label-auto" id="label_3" for="catalogprovider"> Catalog provider </label>
        <div id="cid_3" class="form-input jf-required">
          <select class="form-dropdown" style="width:150px" id="catalogprovider" name="catalogprovider">
            <option value="">  </option>
            <option value="invaluable"> Invaluable </option>
            <option value="sothebys"> Sothebys </option>
          </select>
        </div>
      </ul>
      <ul class="form-line" data-type="control_textarea" id="id_4">
        <label class="form-label form-label-left form-label-auto" id="label_4" for="seller"> Seller </label>
        <div id="cid_4" class="form-input jf-required">
          <textarea id="seller" class="form-textarea" name="seller" cols="40" rows="1"></textarea>
        </div>
      </ul>
      <ul class="form-line" data-type="control_textbox" id="id_5">
        <label class="form-label form-label-left form-label-auto" id="label_5" for="eventId"> EventId </label>
        <div id="cid_5" class="form-input jf-required">
          <input type="text" class=" form-textbox" data-type="input-textbox" id="eventId" name="eventId" size="20" value="" />
        </div>
      </ul>
      <ul class="form-line" data-type="control_dropdown" id="id_6">
        <label class="form-label form-label-left form-label-auto" id="eventStatus" for="input_6"> Event Status </label>
        <div id="cid_6" class="form-input jf-required">
          <select class="form-dropdown" style="width:150px" id="eventStatus" name="eventStatus">
            <option value="">  </option>
            <option value="ENABLE"> ENABLE </option>
            <option value="DISABLE"> DISABLE </option>
          </select>
        </div>
      </ul>
      <ul class="form-line" data-type="control_textarea" id="id_7">
        <label class="form-label form-label-left form-label-auto" id="displayName" for="input_7"> Display Name </label>
        <div id="cid_7" class="form-input jf-required">
          <textarea id="displayName" class="form-textarea" name="displayName" cols="40" rows="1"></textarea>
        </div>
      </ul>
      <ul class="form-line" data-type="control_textarea" id="webDoorImage">
        <label class="form-label form-label-left form-label-auto" id="label_8" for="input_8"> Web Door Image (1536 x 361 Image) </label>
        <div id="cid_8" class="form-input jf-required">
          <textarea id="webDoorImage" class="form-textarea" name="webDoorImage" cols="50" rows="3"></textarea>
        </div>
      </ul>
      <ul class="form-line" data-type="control_textarea" id="id_9">
        <label class="form-label form-label-left form-label-auto" id="mobileImage" for="input_9"> Mobile Event Image (1536 x 730 Image) </label>
        <div id="cid_9" class="form-input jf-required">
          <textarea id="mobileImage" class="form-textarea" name="mobileImage" cols="50" rows="3"></textarea>
        </div>
      </ul>
      <ul class="form-line" data-type="control_button" id="id_2">
        <div id="cid_2" class="form-input-wide">
          <div style="margin-left:156px" class="form-buttons-wrapper">
            <button id="input_2" type="submit" class="form-submit-button">
              Submit
            </button>
          </div>
        </div>
      </ul>
      <ul style="display:none">
        Should be Empty:
        <input type="text" name="website" value="" />
      </ul>
    </ul>
  </div>
  <input type="hidden" id="simple_spc" name="simple_spc" value="51877219856167" />
</form></body>
</html>
