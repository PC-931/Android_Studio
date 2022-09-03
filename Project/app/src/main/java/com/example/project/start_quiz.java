package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class start_quiz extends AppCompatActivity {
    TextView que, que_no;
    Button op1, op2, op3, op4;
    ArrayList<quiz_structure> quizList;
    Random random;
    int score = 0, queAttempt = 1, queCurrent, res=0;
    int[] arr = {0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);

        que = findViewById(R.id.quiz_question);
        que_no = findViewById(R.id.quiz_questionAttempted);
        op1 = findViewById(R.id.quiz_option1);
        op2 = findViewById(R.id.quiz_option2);
        op3 = findViewById(R.id.quiz_option3);
        op4 = findViewById(R.id.quiz_option4);

        quizList = new ArrayList<>();
        random = new Random();

        getQuestionList(quizList);
        queCurrent = random.nextInt(quizList.size());
        setQuestionToTextView(queCurrent);


        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizList.get(queCurrent).getAnswer().trim().toLowerCase().equals(op1.getText().toString().trim().toLowerCase())) {
                    score += 1;
                }
                queAttempt += 1;
                queCurrent = random.nextInt(quizList.size());
                setQuestionToTextView(queCurrent);
            }
        });

        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( quizList.get(queCurrent).getAnswer().trim().toLowerCase().equals(op2.getText().toString().trim().toLowerCase())){
                    score += 1;
                }
                queAttempt +=1;
                queCurrent = random.nextInt(quizList.size());
                setQuestionToTextView(queCurrent);
            }
        });

        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( quizList.get(queCurrent).getAnswer().trim().toLowerCase().equals(op3.getText().toString().trim().toLowerCase())){
                    score += 1;
                }
                queAttempt +=1;
                queCurrent = random.nextInt(quizList.size());
                setQuestionToTextView(queCurrent);
            }
        });

        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( quizList.get(queCurrent).getAnswer().trim().toLowerCase().equals(op4.getText().toString().trim().toLowerCase())){
                    score += 1;
                }
                queAttempt +=1;
                queCurrent = random.nextInt(quizList.size());
                setQuestionToTextView(queCurrent);
            }
        });
    }

    private static int linear_search(int[] arr, int x){
        int n = arr.length;
        for (int j : arr) {
            if (j == x) {
                return 1;
            }
        }
        return -1;
    }

    private void setQuestionToTextView(int queCurrent) {
        que_no.setText("Question Attempted: " + queAttempt + "/10");
        if( queAttempt == 10){
            Intent goto_score = new Intent(start_quiz.this, quiz_result.class);
            goto_score.putExtra("Result", score);
            startActivity(goto_score);
            finish();
        }
        que.setText(quizList.get(queCurrent).getQuestion());
        op1.setText(quizList.get(queCurrent).getOp1());
        op2.setText(quizList.get(queCurrent).getOp2());
        op3.setText(quizList.get(queCurrent).getOp3());
        op4.setText(quizList.get(queCurrent).getOp4());
    }

    private void getQuestionList(ArrayList<quiz_structure> quizList) {
        quizList.add(new quiz_structure("Android is:",
                "an OS", "web browser", "web server", "none of the above",
                "an OS"));
        quizList.add(new quiz_structure("For which of the following Android is mainly developed?",
                "Server", "Desktop", "Laptop", "Moblie",
                "Mobile"));
        quizList.add(new quiz_structure("Android is:",
                "an OS", "web browser", "web server", "none of the above",
                "an OS"));
        quizList.add(new quiz_structure("Android is based on which of the following language?", "java", "c/c++", "python", "none of the above", "java"));

        quizList.add(new quiz_structure("APK stands for:",
                "Android Phone Kit", "Android Page Kit", "Android Package Kit", "none of the above",
                "Android Package Kit"));
        quizList.add(new quiz_structure("What does API stand for:",
                "Application Programming Interface", "Android Programming Interface", "Android Page Interface", "Application Page Interface",
                "Application Programming Interface"));
        quizList.add(new quiz_structure("What is an activity in android:",
                "android class", "android package", "A single screen in an application with supporting java code", "none of the above",
                "A single screen in an application with supporting java code"));
        quizList.add(new quiz_structure("How can we kill an activity in android?",
                "Using finish() method", "Using finishActivity(int requestCode)", "Both (a) and (b)", "none of the above",
                "Both (a) and (b)"));
        quizList.add(new quiz_structure("ADB stands for:",
                "Android debug bridge", "Android delete bridge", "Android destroy bridge", "none of the above",
                "Android debug bridge"));
        quizList.add(new quiz_structure("On which of the following, developers can test the application, during developing the android applications?",
                "Third-party emulators", "Emulator included in Android SDK", "Physical android phone", "All of the above",
                "All of the above"));
        quizList.add(new quiz_structure("Which of the following kernel is used in Android?",
                "Mac", "windows", "linux", "Ubuntu",
                "linux"));
        quizList.add(new quiz_structure("We require an AVD to create an emulator. What does AVD stand for?",
                "Android Virtual device", "Android Virtual display", "Active Virtual display", "Active Virtual device",
                "Android Virtual device"));
        quizList.add(new quiz_structure("Does android support other languages than java?",
                "yes", "no", "maybe", "cant say",
                "yes"));
        quizList.add(new quiz_structure("Which of the following is contained in the src folder?",
                "XML", "Java source code", "Manifest", "none of the above",
                "Java source code"));
        quizList.add(new quiz_structure("Which of the following method is used to handle what happens after clicking a button?",
                "onClick", "onCreate", "onSelect", "none of the above",
                "onClick"));

    }
}