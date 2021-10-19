package com.minionz.qrna.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.zxing.integration.android.IntentIntegrator
import com.minionz.qrna.R
import com.minionz.qrna.data.DefaultResponseData
import com.minionz.qrna.data.QrCertificationRequestData
import com.minionz.qrna.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_my_info
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
            val errorMessage = Toast.makeText(this@MainActivity,"인증에 실패했습니다", Toast.LENGTH_SHORT)

        if(result != null) {
            if(result.contents != null) {
                val requestBody = QrCertificationRequestData("a@a.com","032-888-1111")

                RetrofitBuilder.networkService.certification(requestBody).enqueue(object :
                    Callback<DefaultResponseData> {
                    override fun onFailure(call: Call<DefaultResponseData>, t: Throwable) {
                        errorMessage.show()
                    }

                    override fun onResponse(
                        call: Call<DefaultResponseData>,
                        response: Response<DefaultResponseData>
                    ) {
                        val res = response.body()
                        if(res?.message == "방문 기록 성공") {
                            Toast.makeText(
                                this@MainActivity,
                                "인증이 완료되었습니다",
                                Toast.LENGTH_SHORT
                            ).show()
                            navController.navigate(R.id.action_navigation_dashboard_to_navigation_home)
                        }
                        else errorMessage.show()
                    }
                })

            } else {
                Toast.makeText(this,"저장된 데이터가 없습니다", Toast.LENGTH_SHORT).show()
                finish()
            }
        } else {
            Toast.makeText(this,"인증이 취소되었습니다", Toast.LENGTH_SHORT).show()
            finish()
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}