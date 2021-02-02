package com.example;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.utils.CDDCUtils;
import com.example.utils.SampleOrchestrationCallback;
import com.example.utils.UIUtils;
import com.multiva.bmdc.R;
import com.vasco.orchestration.client.Orchestrator;
import com.vasco.orchestration.client.authentication.UserAuthenticationCallback;
import com.vasco.orchestration.client.flows.CryptoAppIndex;
import com.vasco.orchestration.client.flows.PasswordError;
import com.vasco.orchestration.client.flows.ProtectionType;
import com.vasco.orchestration.client.flows.activation.online.OnlineActivationCallback;
import com.vasco.orchestration.client.flows.activation.online.OnlineActivationInputError;
import com.vasco.orchestration.client.flows.activation.online.OnlineActivationParams;
import com.vasco.orchestration.client.flows.local_authentication.LocalAuthenticationCallback;
import com.vasco.orchestration.client.flows.local_authentication.LocalAuthenticationParams;
import com.vasco.orchestration.client.user.OrchestrationUser;

public class GenerateToken extends
        AppCompatActivity implements LocalAuthenticationCallback, OnlineActivationCallback {
    // Orchestration
    private Orchestrator orchestrator;
    private ProtectionType selectedProtectionType;

    // UI components
    private String userIdView;
    //private EditText challengeView;
    private Dialog progressDialog;
    private SampleOrchestrationCallback orchestrationCallback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Log.d("","aqui");
    }

    public void onGenerateOtp(Context context, String userId){
        userIdView = "angel06";
        selectedProtectionType = ProtectionType.NO_PASSWORD;

        // Get orchestrator instance
        orchestrationCallback = new SampleOrchestrationCallback(App.getAppContext());
        Orchestrator.Builder builder = new Orchestrator.Builder();
        orchestrator = builder
                .setDigipassSalt(Constants.SALT_DIGIPASS)
                .setStorageSalt(Constants.SALT_STORAGE)
                .setContext(App.getAppContext())
                .setDefaultDomain(Constants.DOMAIN)
                .setCDDCParams(CDDCUtils.getCDDCParams())
                .setErrorCallback(orchestrationCallback)
                .setWarningCallback(orchestrationCallback)
                .build();

        CDDCUtils.configure(orchestrator.getCDDCDataFeeder());

        LocalAuthenticationParams localAuthenticationParams = new LocalAuthenticationParams();
        localAuthenticationParams.setOrchestrationUser(new OrchestrationUser(userId));
        localAuthenticationParams.setCryptoAppIndex(CryptoAppIndex.SECOND);
        localAuthenticationParams.setProtectionType(selectedProtectionType);
        localAuthenticationParams.setLocalAuthenticationCallback(this);

        // Used for custom password instead of default one
        orchestrator.setUserAuthenticationCallback(orchestrationCallback, new UserAuthenticationCallback.UserAuthentication[]{UserAuthenticationCallback.UserAuthentication.PASSWORD});
        // Start local authentication
        //progressDialog = UIUtils.displayProgress(App.getAppContext(), getString(R.string.dialog_progress_local_auth));

        //orchestrationCallback.setProgressDialog(progressDialog);
        // Create activation configuration
        String activationPassword = "u666";
        OnlineActivationParams activationParams = new OnlineActivationParams();
        activationParams.setActivationCallback(this);
        activationParams.setOrchestrationUser(new OrchestrationUser(userId));
        activationParams.setActivationPassword(activationPassword);

        orchestrator.startActivation(activationParams);
        orchestrator.startLocalAuthentication(localAuthenticationParams);

    }

    @Override
    public void onLocalAuthenticationSuccess(String s, String s1) {
        Log.d("","aqui");
    }

    @Override
    public void onLocalAuthenticationAborted() {
        Log.d("","aqui");
    }

    @Override
    public void onLocalAuthenticationPasswordError(PasswordError passwordError) {
        Log.d("","aqui");
    }

    @Override
    public void onActivationStepComplete(String s) {
        Log.d("","aqui");
    }

    @Override
    public void onActivationSuccess() {
        Log.d("","aqui");
    }

    @Override
    public void onActivationInputError(OnlineActivationInputError onlineActivationInputError) {
        Log.d("","aqui");
    }

    @Override
    public void onActivationAborted() {
        Log.d("","aqui");
    }
}
