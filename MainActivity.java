package com.example.lanchoicefirebase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.common.modeldownload.FirebaseModelDownloadConditions;
import com.google.firebase.ml.naturallanguage.FirebaseNaturalLanguage;
import com.google.firebase.ml.naturallanguage.languageid.FirebaseLanguageIdentification;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslateLanguage;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslator;
import com.google.firebase.ml.naturallanguage.translate.FirebaseTranslatorOptions;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    String stringHolder;
    String[] languageList;
    String name = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        languageList = new String[]{"Afrikaans", "العربية", "Беларус", "български", "বাংলা",
                "Català", "čeština", "Cymraeg", "dansk", "Deutsche", "Ελληνικά", "English",
                "Esperanto", "Español", "eesti", "فارسی", "Suomalainen", "Français", "Gaeilge",
                "Galego", "ગુજરાતી", "हिन्दी", "Hrvatski", "Ayisyen", "Magyar", "indonesia", "Íslensku",
                "Italiano", "日本人", "ಕನ್ನಡ", "한국어", "Lietuvis", "Latvietis", "Македонски", "मराठी",
                "Melayu", "Malti", "Nederlands", "norsk", "Polskie", "Português", "Română",
                "русский", "shqiptar", "svenska", "Kiswahili", "தமிழ்", "తెలుగు", "ไทย", "Türk",
                "Українська", "اردو", "Tiếng Việt", "中文"};


        textView = findViewById(R.id.source_language);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
            }
        });

        getData();
        //setData(name);

        if (name.isEmpty()){
            showStartDialog();
        }

       // showStartDialog();

//        SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);
//        boolean isFirstStart = preferences.getBoolean("firstStart", true);
//
//        if (isFirstStart) {
//            showStartDialog();
//        }
    }

    void setData(String language) {
        SharedPreferences sharedPreferences = getSharedPreferences("key", MODE_PRIVATE);
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("language", language);
        editor.apply();
    }

    void getData() {
        SharedPreferences sharedPreferences = getSharedPreferences("key", MODE_PRIVATE);
        name = sharedPreferences.getString(stringHolder, "");
    }

    void updateData(){
        textView.setText(name);
    }

    private void showStartDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Choose your language..")
                .setSingleChoiceItems(languageList, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (languageList[i]) {
                            case "Afrikaans":
                                setData(name);
                                identifyLanguage("af");
                                break;
                            case "العربية":
                                identifyLanguage("ar");
                                break;
                            case "Беларус":
                                identifyLanguage("be");
                                break;
                            case "български":
                                identifyLanguage("bg");
                                break;
                            case "বাংলা":
                                identifyLanguage("bn");
                                break;
                            case "Català":
                                identifyLanguage("ca");
                                break;
                            case "čeština":
                                identifyLanguage("cs");
                                break;
                            case "Cymraeg":
                                identifyLanguage("cy");
                                break;
                            case "dansk":
                                identifyLanguage("da");
                                break;
                            case "Deutsche":
                                identifyLanguage("de");
                                break;
                            case "Ελληνικά":
                                identifyLanguage("el");
                                break;
                            case "English":
                                identifyLanguage("en");
                                break;
                            case "Esperanto":
                                identifyLanguage("eo");
                                break;
                            case "Español":
                                identifyLanguage("es");
                                break;
                            case "eesti":
                                identifyLanguage("et");
                                break;
                            case "فارسی":
                                identifyLanguage("fa");
                                break;
                            case "Suomalainen":
                                identifyLanguage("fi");
                                break;
                            case "Français":
                                identifyLanguage("fr");
                                break;
                            case "Gaeilge":
                                identifyLanguage("ga");
                                break;
                            case "Galego":
                                identifyLanguage("gl");
                                break;
                            case "ગુજરાતી":
                                identifyLanguage("gu");
                                break;
                            case "हिन्दी":
                                identifyLanguage("hi");
                                break;
                            case "Hrvatski":
                                identifyLanguage("hr");
                                break;
                            case "Ayisyen":
                                identifyLanguage("ht");
                                break;
                            case "Magyar":
                                identifyLanguage("hu");
                                break;
                            case "indonesia":
                                identifyLanguage("id");
                                break;
                            case "Íslensku":
                                identifyLanguage("is");
                                break;
                            case "Italiano":
                                identifyLanguage("it");
                                break;
                            case "日本人":
                                identifyLanguage("ja");
                                break;
                            case "ಕನ್ನಡ":
                                identifyLanguage("kn");
                                break;
                            case "한국어":
                                identifyLanguage("ko");
                                break;
                            case "Lietuvis":
                                identifyLanguage("lt");
                                break;
                            case "Latvietis":
                                identifyLanguage("lv");
                                break;
                            case "Македонски":
                                identifyLanguage("mk");
                                break;
                            case "मराठी":
                                identifyLanguage("mr");
                                break;
                            case "Melayu":
                                identifyLanguage("ms");
                                break;
                            case "Malti":
                                identifyLanguage("mt");
                                break;
                            case "Nederlands":
                                identifyLanguage("nl");
                                break;
                            case "norsk":
                                identifyLanguage("no");
                                break;
                            case "Polskie":
                                identifyLanguage("pl");
                                break;
                            case "Português":
                                identifyLanguage("pt");
                                break;
                            case "Română":
                                identifyLanguage("ro");
                                break;
                            case "русский":
                                identifyLanguage("ru");
                                break;
                            case "shqiptar":
                                identifyLanguage("sq");
                                break;
                            case "svenska":
                                identifyLanguage("sv");
                                break;
                            case "Kiswahili":
                                identifyLanguage("sw");
                                break;
                            case "தமிழ்":
                                identifyLanguage("ta");
                                break;
                            case "తెలుగు":
                                identifyLanguage("te");
                                break;
                            case "ไทย":
                                identifyLanguage("th");
                                break;
                            case "Türk":
                                identifyLanguage("tr");
                                break;
                            case "Українська":
                                identifyLanguage("uk");
                                break;
                            case "اردو":
                                identifyLanguage("ur");
                                break;
                            case "Tiếng Việt":
                                identifyLanguage("vi");
                                break;
                            case "中文":
                                identifyLanguage("zh");
                                break;
                        }

                        dialogInterface.dismiss();

                    }
                }).create().show();

//        SharedPreferences sharedPreferences;
//        sharedPreferences = getSharedPreferences("preferences", MODE_PRIVATE);
//        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putBoolean("firstStart", false);
//        editor.apply();
    }


    private void identifyLanguage(final String destinationLanguage) {

        /** param String destinationLanguage is for setting value on DialogInterface onClick method*/

        stringHolder = textView.getText().toString();

        FirebaseLanguageIdentification identification = FirebaseNaturalLanguage
                .getInstance()
                .getLanguageIdentification();

        identification
                .identifyLanguage(stringHolder)
                .addOnSuccessListener(new OnSuccessListener<String>() {
                    @Override
                    public void onSuccess(String stringSourceText) {
                        if (stringSourceText.equals("und")) {
                            Toast.makeText(MainActivity.this, "Can't detect language..!", Toast.LENGTH_LONG).show();
                        } else {
                            getLanguageCode(stringSourceText, destinationLanguage);
                        }
                    }
                });
    }

    private void getLanguageCode(String languageType, String codeValue) {

        int unique_language_code;

        switch (codeValue) {
            case "af":
                unique_language_code = FirebaseTranslateLanguage.AF;
                break;
            case "ar":
                unique_language_code = FirebaseTranslateLanguage.AR;
                break;
            case "be":
                unique_language_code = FirebaseTranslateLanguage.BE;
                break;
            case "bg":
                unique_language_code = FirebaseTranslateLanguage.BG;
                break;
            case "bn":
                unique_language_code = FirebaseTranslateLanguage.BN;
                break;
            case "ca":
                unique_language_code = FirebaseTranslateLanguage.CA;
                break;
            case "cs":
                unique_language_code = FirebaseTranslateLanguage.CS;
                break;
            case "cy":
                unique_language_code = FirebaseTranslateLanguage.CY;
                break;
            case "da":
                unique_language_code = FirebaseTranslateLanguage.DA;
                break;
            case "de":
                unique_language_code = FirebaseTranslateLanguage.DE;
                break;
            case "el":
                unique_language_code = FirebaseTranslateLanguage.EL;
                break;
            case "en":
                unique_language_code = FirebaseTranslateLanguage.EN;
                break;
            case "eo":
                unique_language_code = FirebaseTranslateLanguage.EO;
                break;
            case "es":
                unique_language_code = FirebaseTranslateLanguage.ES;
                break;
            case "et":
                unique_language_code = FirebaseTranslateLanguage.ET;
                break;
            case "fa":
                unique_language_code = FirebaseTranslateLanguage.FA;
                break;
            case "fi":
                unique_language_code = FirebaseTranslateLanguage.FI;
                break;
            case "fr":
                unique_language_code = FirebaseTranslateLanguage.FR;
                break;
            case "ga":
                unique_language_code = FirebaseTranslateLanguage.GA;
                break;
            case "gl":
                unique_language_code = FirebaseTranslateLanguage.GL;
                break;
            case "gu":
                unique_language_code = FirebaseTranslateLanguage.GU;
                break;
            case "hi":
                unique_language_code = FirebaseTranslateLanguage.HI;
                break;
            case "hr":
                unique_language_code = FirebaseTranslateLanguage.HR;
                break;
            case "ht":
                unique_language_code = FirebaseTranslateLanguage.HT;
                break;
            case "hu":
                unique_language_code = FirebaseTranslateLanguage.HU;
                break;
            case "id":
                unique_language_code = FirebaseTranslateLanguage.ID;
                break;
            case "is":
                unique_language_code = FirebaseTranslateLanguage.IS;
                break;
            case "it":
                unique_language_code = FirebaseTranslateLanguage.IT;
                break;
            case "ja":
                unique_language_code = FirebaseTranslateLanguage.JA;
                break;
            case "kn":
                unique_language_code = FirebaseTranslateLanguage.KN;
                break;
            case "ko":
                unique_language_code = FirebaseTranslateLanguage.KO;
                break;
            case "lt":
                unique_language_code = FirebaseTranslateLanguage.LT;
                break;
            case "lv":
                unique_language_code = FirebaseTranslateLanguage.LV;
                break;
            case "mk":
                unique_language_code = FirebaseTranslateLanguage.MK;
                break;
            case "mr":
                unique_language_code = FirebaseTranslateLanguage.MR;
                break;
            case "ms":
                unique_language_code = FirebaseTranslateLanguage.MS;
                break;
            case "mt":
                unique_language_code = FirebaseTranslateLanguage.MT;
                break;
            case "nl":
                unique_language_code = FirebaseTranslateLanguage.NL;
                break;
            case "no":
                unique_language_code = FirebaseTranslateLanguage.NO;
                break;
            case "pl":
                unique_language_code = FirebaseTranslateLanguage.PL;
                break;
            case "pt":
                unique_language_code = FirebaseTranslateLanguage.PT;
                break;
            case "ro":
                unique_language_code = FirebaseTranslateLanguage.RO;
                break;
            case "ru":
                unique_language_code = FirebaseTranslateLanguage.RU;
                break;
            case "sq":
                unique_language_code = FirebaseTranslateLanguage.SQ;
                break;
            case "sv":
                unique_language_code = FirebaseTranslateLanguage.SV;
                break;
            case "sw":
                unique_language_code = FirebaseTranslateLanguage.SW;
                break;
            case "ta":
                unique_language_code = FirebaseTranslateLanguage.TA;
                break;
            case "te":
                unique_language_code = FirebaseTranslateLanguage.TE;
                break;
            case "th":
                unique_language_code = FirebaseTranslateLanguage.TH;
                break;
            case "tr":
                unique_language_code = FirebaseTranslateLanguage.TR;
                break;
            case "ur":
                unique_language_code = FirebaseTranslateLanguage.UR;
                break;
            case "uk":
                unique_language_code = FirebaseTranslateLanguage.UK;
                break;
            case "vi":
                unique_language_code = FirebaseTranslateLanguage.VI;
                break;
            case "zh":
                unique_language_code = FirebaseTranslateLanguage.ZH;
                break;
            default:
                unique_language_code = 0;
        }
        translateText(unique_language_code);
    }

    private void translateText(int languageCode) {

        FirebaseTranslatorOptions options = new FirebaseTranslatorOptions
                .Builder()
                .setSourceLanguage(FirebaseTranslateLanguage.BN)
                .setTargetLanguage(languageCode)
                .build();


        final FirebaseTranslator translator = FirebaseNaturalLanguage.getInstance().getTranslator(options);

        FirebaseModelDownloadConditions conditions = new FirebaseModelDownloadConditions.Builder().build();

        translator.downloadModelIfNeeded(conditions).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                translator.translate(stringHolder).addOnSuccessListener(new OnSuccessListener<String>() {
                    @Override
                    public void onSuccess(String s) {
                        textView.setText(s);
                    }
                });
            }
        });
    }
}