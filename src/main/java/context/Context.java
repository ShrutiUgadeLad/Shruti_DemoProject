package context;

import dataModel.LoginDataModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {

        private static Map<String, List<String>> list = new HashMap<String, List<String>>();

        private static Map<String, String> listItem = new HashMap<String, String>();
        private LoginDataModel loginDataModel;

        public LoginDataModel getLoginDataModel() { return loginDataModel; }

        public void setLoginDataModel(LoginDataModel loginDataModel) {
            this.loginDataModel = loginDataModel;
        }
}
