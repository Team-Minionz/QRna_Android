package com.minionz.qrna.view.qr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import com.minionz.qrna.R
import com.minionz.qrna.data.QrCertificationRequestData
import com.minionz.qrna.data.QrCertificationResponseData
import com.minionz.qrna.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QrCodeReaderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr_code_reader)

        initQrCodeScan()
    }

    private fun initQrCodeScan() {

        val integrator = IntentIntegrator(this)
        integrator.setBeepEnabled(false)
        integrator.setOrientationLocked(true)
        integrator.setPrompt("QR코드를 인증해주세요")
        integrator.initiateScan()

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)
        val errorMessage = Toast.makeText(this@QrCodeReaderActivity,"인증에 실패했습니다",Toast.LENGTH_SHORT)

        if(result != null) {
            if(result.contents != null) {
                val requestBody = QrCertificationRequestData("","")

                RetrofitBuilder.networkService.certification(requestBody).enqueue(object : Callback<QrCertificationResponseData> {
                    override fun onFailure(call: Call<QrCertificationResponseData>, t: Throwable) {
                        errorMessage.show()
                    }

                    override fun onResponse(
                        call: Call<QrCertificationResponseData>,
                        response: Response<QrCertificationResponseData>
                    ) {
                        if(response.isSuccessful) {
                            Toast.makeText(
                                this@QrCodeReaderActivity,
                                "인증이 완료되었습니다",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        else errorMessage.show()

                        finish()
                    }
                })
                Log.e("data",result.contents)

            } else {
                Toast.makeText(this,"저장된 데이터가 없습니다",Toast.LENGTH_SHORT).show()
                finish()
            }
        } else {
            Toast.makeText(this,"인증이 취소되었습니다",Toast.LENGTH_SHORT).show()
            finish()
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}