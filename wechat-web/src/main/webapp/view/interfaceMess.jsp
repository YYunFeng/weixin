<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: yyfpc
  Date: 13-4-21
  Time: 下午5:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="../js/fouseJS.js"></script>
<h3>接口配置信息</h3>
<div class="dev_desc" style="margin-top:8px;">
    <dl class="dev_desc_col_l">
        <dd class="dev_tip">
            <label>URL：</label>
            <strong><s:property value="userWeiXin.url"/></strong>
        </dd>
        <dd class="dev_tip">
            <label>Token：</label>
            <strong><s:property value="userWeiXin.interfaceToken"/></strong>
        </dd>
    </dl>
    <div class="clr"></div>
</div>
<br />
<h3>如何运用上面的接口配置信息</h3>
<div class="helpline">
    <div id="helplineicon1" class="helplineicon_hover"  style="cursor: pointer" onclick="fouseJS.deployhelp(1)">1</div>
    <div id="helplineicon2" class="helplineicon_w icon2" style="cursor: pointer" onclick="fouseJS.deployhelp(2)">2</div>
    <div id="helplineicon3" class="helplineicon_w icon3" style="cursor: pointer" onclick="fouseJS.deployhelp(3)">3</div>
    <div id="helplineicon4" class="helplineicon_w icon4" style="cursor: pointer" onclick="fouseJS.deployhelp(4)">4</div>
    <div id="helplineicon5" class="helplineicon_w icon5" style="cursor: pointer" onclick="fouseJS.deployhelp(5)">5</div>
</div>
<div class="clr"></div>
<div class="helpdeploys">

    <div id="help_c1" style="display:block;">
        <div>
            <p>
                1.1 登录微信公众平台(<a href="https://mp.weixin.qq.com" target="_blank">https://mp.weixin.qq.com</a>)
            </p>
            <p>
                1.2 登录成功后，点击“高级模式”
            </p>
        </div>
        <div class="help_c1_img"></div>
        <div class="help_btndiv">
            <a class="btnGreen" onclick="fouseJS.deployhelp(2);">下一步</a>
        </div>
    </div>
    <div id="help_c2" style="display:none;">
        <div>
            <p>
                如果想在开发模式下设置URL和Token的话，我们需要先将“编辑模式”关闭，再将“开发模式”开启。
            </p>
            <p>
                2.1 进入“高级模式”，点击左侧的“编辑模式”
            </p>
            <p>
                2.2 进入“编辑模式”后，点击右侧的开关，将“开启”变为“关闭”
            </p>
        </div>
        <div class="help_c2_img"></div>
        <div class="help_btndiv">
            <a class="btnGreen" onclick="fouseJS.deployhelp(1);">上一步</a>
            <a class="btnGreen" onclick="fouseJS.deployhelp(3);">下一步</a>
        </div>
    </div>
    <div id="help_c3" style="display:none;">
        <div>
            <p>
                将“编辑模式”关闭后，如果你还不是开发者，你需要先进入“开发模式”，成为开发者，才能配置URL和Token值。
            </p>
            <p>
                3.1 再次进入“高级模式”，点击右侧的“开发模式”
            </p>
            <p>
                3.2 进入“开发模式”后，点击下面的“成为开发者”按钮
            </p>
            <p>
                3.3 然后将上面的URL和Token值依次复制到输入框中
            </p>
        </div>
        <div class="help_c3_img"></div>
        <div class="help_btndiv">
            <a class="btnGreen" onclick="fouseJS.deployhelp(2);">上一步</a>
            <a class="btnGreen" onclick="fouseJS.deployhelp(4);">下一步</a>
        </div>
    </div>
    <div id="help_c4" style="display:none;">
        <div>
            <p>
                成为开发者后，就可以开启右侧的开关啦。
            </p>
        </div>
        <div class="help_c4_img"></div>
        <div class="help_btndiv">
            <a class="btnGreen" onclick="fouseJS.deployhelp(3);">上一步</a>
            <a class="btnGreen" onclick="fouseJS.deployhelp(5);">下一步</a>
        </div>
    </div>
    <div id="help_c5" style="display:none;">
        <div>
            <p>
                恭喜你，你已经将你的公众账号拥有更加强大的功能，快用微信直通车开创你的公众平台新体验吧！
            </p>
        </div>
        <div class="help_c5_img"></div>
        <div class="help_btndiv">
            <a class="btnGreen" onclick="fouseJS.deployhelp(4);">上一步</a>
        </div>
    </div>


</div>
