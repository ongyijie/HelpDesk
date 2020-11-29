package my.edu.tarc.helpdesk

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Defining database
        val database1 = FirebaseDatabase.getInstance("https://bait2123-202010-03.firebaseio.com")
        val database2 = FirebaseDatabase.getInstance("https://solenoid-lock-f65e8.firebaseio.com")

        //Write to common resources firebase
        val data1 = database1.getReference("PI_03_CONTROL")

        //Write to personal firebase
        val data2 = database2.getReference("PI_03_CONTROL")

        //Link program to UI
        val buttonRoom1: Button = findViewById(R.id.buttonRoom1)
        val buttonRoom2: Button = findViewById(R.id.buttonRoom2)
        val buttonRoom3: Button = findViewById(R.id.buttonRoom3)
        val buttonRoom4: Button = findViewById(R.id.buttonRoom4)

        //Declaring variables
        val lcdscr: String?
        val lcdtxt: String?
        val lcdbkR: String?
        val lcdbkG: String?
        val lcdbkB: String?
        val request: String?
        lcdscr = "1"
        lcdtxt = "=APP IS RUNNING="
        lcdbkR = "10"
        lcdbkG = "10"
        lcdbkB = "10"
        request = "0"

        //Get "Help" status from real-time database
        data2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val factor = dataSnapshot.child("request").value.toString()
                val selection = dataSnapshot.child("selection").value.toString()

                //Codes written from this part onwards are for demo purpose only. In real life each room has its own sensor
                //If "Help" command is triggered, display notification
                when (factor) {
                    "1" -> {
                        when (selection) {  //Check which room is sending request
                            "1" -> {
                                buttonRoom1.setBackgroundColor(buttonRoom2.context.resources.getColor(R.color.green))

                                //Manual button for staff to dismiss notification
                                buttonRoom1.setOnClickListener {
                                    buttonRoom1.setBackgroundColor(buttonRoom1.context.resources.getColor(R.color.gray))
                                    data1.child("lcdscr").setValue(lcdscr)
                                    data1.child("lcdtxt").setValue(lcdtxt)
                                    data1.child("lcdbkR").setValue(lcdbkR)
                                    data1.child("lcdbkG").setValue(lcdbkG)
                                    data1.child("lcdbkB").setValue(lcdbkB)

                                    data2.child("lcdscr").setValue(lcdscr)
                                    data2.child("lcdtxt").setValue(lcdtxt)
                                    data2.child("lcdbkR").setValue(lcdbkR)
                                    data2.child("lcdbkG").setValue(lcdbkG)
                                    data2.child("lcdbkB").setValue(lcdbkB)
                                    data2.child("request").setValue(request)
                                }
                            }
                            "2" -> {
                                buttonRoom2.setBackgroundColor(buttonRoom2.context.resources.getColor(R.color.green))
                                buttonRoom2.setOnClickListener {
                                    buttonRoom2.setBackgroundColor(buttonRoom2.context.resources.getColor(R.color.gray))
                                    data1.child("lcdscr").setValue(lcdscr)
                                    data1.child("lcdtxt").setValue(lcdtxt)
                                    data1.child("lcdbkR").setValue(lcdbkR)
                                    data1.child("lcdbkG").setValue(lcdbkG)
                                    data1.child("lcdbkB").setValue(lcdbkB)

                                    data2.child("lcdscr").setValue(lcdscr)
                                    data2.child("lcdtxt").setValue(lcdtxt)
                                    data2.child("lcdbkR").setValue(lcdbkR)
                                    data2.child("lcdbkG").setValue(lcdbkG)
                                    data2.child("lcdbkB").setValue(lcdbkB)
                                    data2.child("request").setValue(request)
                                }
                            }
                            "3" -> {
                                buttonRoom3.setBackgroundColor(buttonRoom3.context.resources.getColor(R.color.green))
                                buttonRoom3.setOnClickListener {
                                    buttonRoom3.setBackgroundColor(buttonRoom3.context.resources.getColor(R.color.gray))
                                    data1.child("lcdscr").setValue(lcdscr)
                                    data1.child("lcdtxt").setValue(lcdtxt)
                                    data1.child("lcdbkR").setValue(lcdbkR)
                                    data1.child("lcdbkG").setValue(lcdbkG)
                                    data1.child("lcdbkB").setValue(lcdbkB)

                                    data2.child("lcdscr").setValue(lcdscr)
                                    data2.child("lcdtxt").setValue(lcdtxt)
                                    data2.child("lcdbkR").setValue(lcdbkR)
                                    data2.child("lcdbkG").setValue(lcdbkG)
                                    data2.child("lcdbkB").setValue(lcdbkB)
                                    data2.child("request").setValue(request)
                                }
                            }
                            "4" -> {
                                buttonRoom4.setBackgroundColor(buttonRoom4.context.resources.getColor(R.color.green))
                                buttonRoom4.setOnClickListener {
                                    buttonRoom4.setBackgroundColor(buttonRoom4.context.resources.getColor(R.color.gray))
                                    data1.child("lcdscr").setValue(lcdscr)
                                    data1.child("lcdtxt").setValue(lcdtxt)
                                    data1.child("lcdbkR").setValue(lcdbkR)
                                    data1.child("lcdbkG").setValue(lcdbkG)
                                    data1.child("lcdbkB").setValue(lcdbkB)

                                    data2.child("lcdscr").setValue(lcdscr)
                                    data2.child("lcdtxt").setValue(lcdtxt)
                                    data2.child("lcdbkR").setValue(lcdbkR)
                                    data2.child("lcdbkG").setValue(lcdbkG)
                                    data2.child("lcdbkB").setValue(lcdbkB)
                                    data2.child("request").setValue(request)
                                }
                            }
                        }
                    }
                    "0" -> {
                        when (selection) {
                            "1" -> buttonRoom1.setBackgroundColor(buttonRoom1.context.resources.getColor(R.color.gray))
                            "2" -> buttonRoom2.setBackgroundColor(buttonRoom2.context.resources.getColor(R.color.gray))
                            "3" -> buttonRoom3.setBackgroundColor(buttonRoom3.context.resources.getColor(R.color.gray))
                            "4" -> buttonRoom4.setBackgroundColor(buttonRoom4.context.resources.getColor(R.color.gray))
                        }
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("Error", "Read failed")
            }
        })
    }
}