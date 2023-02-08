package com.uit.finalproject;

import java.io.IOException;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static Retrofit retrofit = null;

    //private static String token ="eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJLcHRXNWJCcTlsRGliY2s5NHI3TldHQVl0SHBrUFI3N1A4V0hMWDVIX1E0In0.eyJleHAiOjE2Njk5MDU1MjEsImlhdCI6MTY2OTgxOTEyMSwiYXV0aF90aW1lIjoxNjY5ODE5MTIxLCJqdGkiOiI2OGM5ODY1Ny0xYmI1LTQxODQtYjBhNS1hY2FjOWQ3NTBiMzUiLCJpc3MiOiJodHRwczovLzEwMy4xMjYuMTYxLjE5OS9hdXRoL3JlYWxtcy9tYXN0ZXIiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiMTAxZGQ1MmMtMjNiYS00ZjM4LWExMjQtYjc4MGUxYjVhODFiIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoib3BlbnJlbW90ZSIsInNlc3Npb25fc3RhdGUiOiJhODIwZDI2ZC05ZWVkLTRlNDctOWMxMC00MTg2OWQ1NWI1YzIiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbImh0dHBzOi8vbG9jYWxob3N0IiwiaHR0cHM6Ly8xMDMuMTI2LjE2MS4xOTkiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtbWFzdGVyIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7Im9wZW5yZW1vdGUiOnsicm9sZXMiOlsicmVhZDp1c2VycyIsInJlYWQ6bG9ncyIsInJlYWQ6bWFwIiwicmVhZDpydWxlcyIsInJlYWQ6YXNzZXRzIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJhODIwZDI2ZC05ZWVkLTRlNDctOWMxMC00MTg2OWQ1NWI1YzIiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6InVzZXIxIn0.VTbUW5Jdmla8PiQHe_f-LN-obJwtKheEDjgZBDXmNrPtE4xqCjSKJt8xRWVzmuo3BN21UD9q3BUkigYt3VAn7zUL4uo5_2BmpLV3rHf7g4d1yxvrBe7xVjiwNk71ZAjlsEk7XHqvVRAOvPmtvsfpVMq5pp9EK3HgIJb8yGYrZZg5BnZ5LWCPrNMjGylBJY_X_3UNCSf2ldYoSbo7m5FCDgysZ9ydJVVa-2Xsn6p5J6I44o64fNVr4uJ5umPbiGbPmbTfkOuNFZY1XE8evNHdU8jprwcsxXuAGWz3PgMjbJmTE3E8WXyF_HNPoR-eRz31bdsxGz-_3x5rngVc6SRIzg";
    //private static String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJLcHRXNWJCcTlsRGliY2s5NHI3TldHQVl0SHBrUFI3N1A4V0hMWDVIX1E0In0.eyJleHAiOjE2Njk5ODY0MTUsImlhdCI6MTY2OTkwMzUyMiwiYXV0aF90aW1lIjoxNjY5OTAwMDE1LCJqdGkiOiIwZTdkNDNjOC1jOTIwLTQwY2MtYWVhOS03MDZjMjEzNjY1N2EiLCJpc3MiOiJodHRwczovLzEwMy4xMjYuMTYxLjE5OS9hdXRoL3JlYWxtcy9tYXN0ZXIiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiMTAxZGQ1MmMtMjNiYS00ZjM4LWExMjQtYjc4MGUxYjVhODFiIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoib3BlbnJlbW90ZSIsInNlc3Npb25fc3RhdGUiOiJlYmI3NmFhOC1mNTRhLTQxYjMtYTdlZi02NjEzODBjZTllYzUiLCJhY3IiOiIwIiwiYWxsb3dlZC1vcmlnaW5zIjpbImh0dHBzOi8vbG9jYWxob3N0IiwiaHR0cHM6Ly8xMDMuMTI2LjE2MS4xOTkiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtbWFzdGVyIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7Im9wZW5yZW1vdGUiOnsicm9sZXMiOlsicmVhZDp1c2VycyIsInJlYWQ6bG9ncyIsInJlYWQ6bWFwIiwicmVhZDpydWxlcyIsInJlYWQ6YXNzZXRzIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJlYmI3NmFhOC1mNTRhLTQxYjMtYTdlZi02NjEzODBjZTllYzUiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6InVzZXIxIn0.hxj-QYVweEDdkwW1nW5rKg-bpG9lcp4tUfEwNnxxO1eZYrHO6mwEMiVV3Da_-qnXS4Hxlwm3uXP30QwdB-w467X4ZWBExOdQGBUlHYhomYep4imnh6kcjmvk8qbIajfdfyJuOOZy8MS76Oi9pdavS-k0QDerbKtt5UpiAfmks3hkWDsmLqcfMiFrU3SrmYIn74asKZRnzUB65TAwa5V_upETe-4A8N5OXnEeMP9Dk9iXLD9OzIWQHqJo5HVgg7zNhTsmMJqoGSziXL49X5E5OZcyaJPXjlRfgzaUwti_DMcsKiGVQeD_Z1py0J-Mr3N_jSclLpwSZX6rCctESSlNcQ";
    //private static String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJLcHRXNWJCcTlsRGliY2s5NHI3TldHQVl0SHBrUFI3N1A4V0hMWDVIX1E0In0.eyJleHAiOjE2NzAwNzk5MjgsImlhdCI6MTY2OTk5MzUyOCwiYXV0aF90aW1lIjoxNjY5OTkzNTI4LCJqdGkiOiJkOTQxN2Y3ZS04YTE0LTRhZDItYjQ4OS00MWVkNTRhMmIzYTUiLCJpc3MiOiJodHRwczovLzEwMy4xMjYuMTYxLjE5OS9hdXRoL3JlYWxtcy9tYXN0ZXIiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiMTAxZGQ1MmMtMjNiYS00ZjM4LWExMjQtYjc4MGUxYjVhODFiIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoib3BlbnJlbW90ZSIsInNlc3Npb25fc3RhdGUiOiJlYTUxZmVkYy1lOTg0LTRmNDQtYWFlMC1kMTdiNDg1NjAyMTkiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbImh0dHBzOi8vbG9jYWxob3N0IiwiaHR0cHM6Ly8xMDMuMTI2LjE2MS4xOTkiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtbWFzdGVyIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7Im9wZW5yZW1vdGUiOnsicm9sZXMiOlsicmVhZDp1c2VycyIsInJlYWQ6bG9ncyIsInJlYWQ6bWFwIiwicmVhZDpydWxlcyIsInJlYWQ6YXNzZXRzIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJlYTUxZmVkYy1lOTg0LTRmNDQtYWFlMC1kMTdiNDg1NjAyMTkiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6InVzZXIxIn0.FpYLMl0KzqmmQSKWHQ9tf7Vmzi_dtmmIv3nJJ4QfBYLWo2hvkeMiQzp-qrozx8lmEX09l474vSc_2qeRUwKA6GB9_ef7BY2GBZlrWGxnTsR6zFcJGE0QHJHojdEWJ1WlWUewo-Tqjje0sJfd7vfVyv1oyzQL-atHKpDvCAefd08U46YXVsIoZ_5bDEEX5jgARIOnyLl1QVt3KDAvuf7sSgrD1DOBQB31Ygfq5RbPdEnYHSQMwyepjo9RTg5O6Xf-WMPbCS9tvAlbYwTI8Sc7aZkW1BfOgKBXcjBbChyyUQ1q-f-M5393sKQj12Yj7C4PWT5uf5tjouLQgAaO5-ioGA";
    //private static String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJLcHRXNWJCcTlsRGliY2s5NHI3TldHQVl0SHBrUFI3N1A4V0hMWDVIX1E0In0.eyJleHAiOjE2NzAyMjIxMzcsImlhdCI6MTY3MDEzNTczNywiYXV0aF90aW1lIjoxNjcwMTM1NzM3LCJqdGkiOiJhZTMwZDViNy03N2VlLTRiYTctYWVlYy0xNGMyMGNiOTIxNjgiLCJpc3MiOiJodHRwczovLzEwMy4xMjYuMTYxLjE5OS9hdXRoL3JlYWxtcy9tYXN0ZXIiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiMTAxZGQ1MmMtMjNiYS00ZjM4LWExMjQtYjc4MGUxYjVhODFiIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoib3BlbnJlbW90ZSIsInNlc3Npb25fc3RhdGUiOiJlY2VhM2VhZC1iZDRhLTQ1MTktYTRiMy02MGNiNGViYzNjMTMiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbImh0dHBzOi8vbG9jYWxob3N0IiwiaHR0cHM6Ly8xMDMuMTI2LjE2MS4xOTkiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtbWFzdGVyIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7Im9wZW5yZW1vdGUiOnsicm9sZXMiOlsicmVhZDp1c2VycyIsInJlYWQ6bG9ncyIsInJlYWQ6bWFwIiwicmVhZDpydWxlcyIsInJlYWQ6YXNzZXRzIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJlY2VhM2VhZC1iZDRhLTQ1MTktYTRiMy02MGNiNGViYzNjMTMiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6InVzZXIxIn0.dQZ6ZiH1wr5yuex2hIt2OtV2UHksoj21mmoBNEmGkXPW78Vm7o9uVp7vTtO7w4PNHDSgEdXvzlP7ENcyH6Gg8ddEjJ2gX96brI-VN1IkZDD4Nrl7jyhUDUTjNSV1w8Vtc29dP-mdcdbjNc9gDVrKpePAYabthJjx3sv8ASD6MuW_S0Fg4IlwiDmoBuFgvhf7QfiWP6l16zKZJhSTafoRZcCyS7lhLXIP9aq1q0gA67_ygsxQsPxfnVITtkUxsVUuUywlvI74cjBJNFVFL8lmprEqI5jl1JxokHzGdhwr36UxqJehu1rH2VSORqh_AmejBE9tCd5FokK-8UxLzTCHtA";
    private  static  String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJLcHRXNWJCcTlsRGliY2s5NHI3TldHQVl0SHBrUFI3N1A4V0hMWDVIX1E0In0.eyJleHAiOjE2NzAzMDAwNzMsImlhdCI6MTY3MDI2NDIzMCwiYXV0aF90aW1lIjoxNjcwMjEzNjczLCJqdGkiOiJhODhhMTlmZC02NjMwLTQyNGMtODFiNS0zOWYxODA3NjVmZWEiLCJpc3MiOiJodHRwczovLzEwMy4xMjYuMTYxLjE5OS9hdXRoL3JlYWxtcy9tYXN0ZXIiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiMTAxZGQ1MmMtMjNiYS00ZjM4LWExMjQtYjc4MGUxYjVhODFiIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoib3BlbnJlbW90ZSIsInNlc3Npb25fc3RhdGUiOiJjZTkyYzIwMS0yMjEyLTRjNWMtYTEzNi1jZGZlY2RiZTIyOWIiLCJhY3IiOiIwIiwiYWxsb3dlZC1vcmlnaW5zIjpbImh0dHBzOi8vbG9jYWxob3N0IiwiaHR0cHM6Ly8xMDMuMTI2LjE2MS4xOTkiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtbWFzdGVyIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7Im9wZW5yZW1vdGUiOnsicm9sZXMiOlsicmVhZDp1c2VycyIsInJlYWQ6bG9ncyIsInJlYWQ6bWFwIiwicmVhZDpydWxlcyIsInJlYWQ6YXNzZXRzIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJjZTkyYzIwMS0yMjEyLTRjNWMtYTEzNi1jZGZlY2RiZTIyOWIiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6InVzZXIxIn0.CnfLBApytzmunE4pbGBmE2sRjXLWFXQlBIOI7GLE_qZlWeSVdfiTLumYGammFWnztzrwnh8Wy4EUQBztohanhWPBWtbmtKX5jEbDVquzVFpoLycPK4al00n7oDwQjhx-kTYlfbpx3yP0fwhmBbXtmS1tg5LVgHN_U3JFfO3sDKDcLQ4bBIzz_BAoaPexALzZC-1ZWZs-hnIp2oeitE_lb9OB19vb3f7m9p9idsACpg6E5JlLUwU-4F2aBk8HGuVFAgci7NRLLzmnASE0fA8Y-cSwyIKdCt7saNV-mSCb6aow9feE1IIKLh4yvwFqQNJBBmI5-wdgrlrM1w19RT5tlg";

    private static OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            //Log
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);

            //Bear token
            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newRequest  = chain.request().newBuilder()
                            .addHeader("Authorization", "Bearer " + token)
                            .build();
                    return chain.proceed(newRequest);
                }
            });

            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager)trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            OkHttpClient okHttpClient = builder.build();
            return okHttpClient;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Retrofit getClient() {
        OkHttpClient client = getUnsafeOkHttpClient();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://103.126.161.199/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }

}
