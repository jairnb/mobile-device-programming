package com.example.quizapplab7

import com.example.quizapplab7.db.Question

class Helper {

    companion object {


         fun createQuestion(): ArrayList<Question> {
            var q1 = Question(
                1,
                "Choose the correct option related to Android.",
                "A: Android is a web browser",
                "B: Android is an Operating System",
                "C: Android is a web server",
                "D: None",
                "B",
                "Answer - B) Android is an Operating System"

            )

            var q2 = Question(
                2,
                "What is an activity in android?",
                "A: Android Class",
                "B: Android Package",
                "C: A single screen in an application with supporting java code",
                "D: None of the above",
                "C",
                "Answer - C) A activity is a single screen in an application."
            )

            var q3 = Question(
                3,
                "Choose the option which is contained in the src folder",
                "A: Java Source Code",
                "B: XML",
                "C: Manifest",
                "D: All of them",
                "A",
                "Answer - A) Java source code is contained in the src folder"
            )

            var q4 = Question(
                4,
                "Among the following options choose the one for which Android is based on Linux.",
                "A: Networking",
                "B: Portability",
                "C: Security",
                "D: All of the above",
                "D",
                "Answer - D)  All of the above are reasons for which Android is based on Linux."
            )

            var q5 = Question(
                5,
                "Among the below virtual machines choose the one which is used by the Android operating system",
                "A: Dalvik operating system",
                "B: JVM",
                "C: Simple virtual machine",
                "D: None",
                "A",
                "Answer - A)  Android uses Dalvik operating system."
            )

            var q6 = Question(
                6,
                "Identify the language on which Android is based upon.",
                "A: Python",
                "B: C++",
                "C: Java",
                "D: None",
                "C",
                "Answer - C) Android is based upon Java."
            )

            var q7 = Question(
                7,
                "All layout classes are the subclasses of.",
                "A: android.widget",
                "B: android.view.View",
                "C: android.view.ViewGroup",
                "D: None",
                "C",
                "Answer - C) all layout classes are the subclasses of android.view.ViewGroup in android."
            )

            var q8 = Question(
                8,
                "The full form of APK is",
                "A: Android Page Kit",
                "B: Android Phone Kit",
                "C: Android Package Kit",
                "D: Android Photo Kit",
                "C",
                "Answer - C) APK stands for Android package kit."
            )

            var q9 = Question(
                9,
                "What is manifest XML in android?",
                "A: It has information about layout in an application",
                "B: It has all the information about an application",
                "C:  It has the information about activities in an application",
                "D: None",
                "B",
                "Answer - B) It has all the information about an application"
            )

            var q10 = Question(
                10,
                "What is the use of a content provider in Android?",
                "A: For sharing the data between applications",
                "B: For storing the data in the database",
                "C: For sending the data from an application to another application",
                "D: None of the above",
                "C",
                "Answer - C) A content provider is used to share information between Android applications."
            )

            var q11 = Question(
                11,
                "While developing android application developers can test their apps on",
                "A: Emulators in Android SDK",
                "B: Android Phone",
                "C: Third-Party Emulator",
                "D: All the above",
                "D",
                "Answer - D) Apps can be tested in all the sources mentioned above."
            )

            var q12 = Question(
                12,
                "In android, mini activities are also known as",
                "A: Adapter",
                "B: Activity",
                "C: Fragments",
                "D: None",
                "C",
                "Answer - C) In android, mini activities are also known as Fragments"
            )

            var q13 = Question(
                13,
                "Among the following choose the one which converts Java bytecode into Dalvik bytecode",
                "A: dex compiler",
                "B: Mobile interpretive compare",
                "C: Dalvik converter",
                "D: None",
                "A",
                "Answer - A)  dex compiler converts convert JAVA bytecode into Dalvik bytecode."
            )

            var q14 = Question(
                14,
                "The services in android can be stopped using which of the following method?",
                "A: system. exit()  method",
                "B: stopSelf() and stopService() method",
                "C: finish() method",
                "D: end() method",
                "B",
                "Answer - B) stopSelf() and stopService() method can be used to stop services in android."
            )

            var q15 = Question(
                15,
                "Activity in Android can be killed using?",
                "A: finishActivity (int requestCode)",
                "B: finish() method",
                "C: neither a and b",
                "D: None",
                "D",
                "Answer - D) Activity in Android can be killed using both finishActivity (int requestCode) and finish() method."
            )

            var listQuestion: ArrayList<Question> = ArrayList()
            listQuestion.add(q1)
            listQuestion.add(q2)
            listQuestion.add(q3)
            listQuestion.add(q4)
            listQuestion.add(q5)
            listQuestion.add(q6)
            listQuestion.add(q7)
            listQuestion.add(q8)
            listQuestion.add(q9)
            listQuestion.add(q10)
            listQuestion.add(q11)
            listQuestion.add(q12)
            listQuestion.add(q13)
            listQuestion.add(q14)
            listQuestion.add(q15)

            return listQuestion
        }
    }
}