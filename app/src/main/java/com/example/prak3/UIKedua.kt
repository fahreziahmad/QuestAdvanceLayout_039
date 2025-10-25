package com.example.prak3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prak3.ui.theme.Prak3Theme



// Composable utama untuk seluruh layar
@Composable
fun ProfileScreen(modifier: Modifier) {
    Surface(
        color = Color(0xFF121212), // Background hitam
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()) // Agar bisa di-scroll
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            // 1. Gambar Profil Bulat
            Image(
                painter = painterResource(id = R.drawable.poto_me), // Ganti dengan gambar profil Anda
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )

            // 2. Ikon Sosial Media
            Row (
                modifier = Modifier.padding(top = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Ganti R.drawable.ic_facebook, dll dengan ikon Anda
                SocialIcon(painterRes = R.drawable.facebook, color = Color(0xFF3b5998))
                SocialIcon(painterRes = R.drawable.instagram, color = Color(0xFFdb4a39))
                SocialIcon(painterRes = R.drawable.twitter, color = Color(0xFF1da1f2))
                SocialIcon(painterRes = R.drawable.linkedin, color = Color(0xFF0077b5))
            }

            // 3. Nama
            Text(
                text = "Fahrezi Ahmad Syahyana",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )

            // 4. Username
            Text(
                text = "@Fahrezi_Ahmad",
                color = Color(0xFFB0B0B0),
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 4.dp)
            )

            // 5. Bio
            Text(
                text = "Saya seorang progamming",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // 6. Tombol Opsi
            ProfileOptionButton(
                text = "Privacy",
                icon = Icons.Outlined.Lock
            )
            Spacer(modifier = Modifier.height(16.dp))
            ProfileOptionButton(
                text = "Riwayat Transaksi",
                icon = Icons.Outlined.Refresh
            )
            Spacer(modifier = Modifier.height(16.dp))
            ProfileOptionButton(
                text = "Pengaturan",
                icon = Icons.Outlined.Settings
            )

            // Spacer untuk mendorong logout ke bawah
            Spacer(modifier = Modifier.weight(1f))

            // 7. Tombol Logout
            Button(
                onClick = { /* Aksi logout */ },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 32.dp)
            ) {
                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Logout",
                        tint = Color.White
                    )
                    Text(
                        text = "Logout",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }

            // 8. Copyright
            Text(
                text = "© 2025 Fahrezi Ahmad Syhayana",
                color = Color(0xFFB0B0B0),
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

// Composable kustom untuk tombol opsi
@Composable
fun ProfileOptionButton(text: String, icon: ImageVector) {
    Button(
        onClick = { /* Aksi tombol */ },
        shape = RoundedCornerShape(28.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF0F0F0)),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = text,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            )
            Icon(
                imageVector = Icons.Outlined.PlayArrow, // Ikon panah kanan
                contentDescription = null,
                tint = Color(0xFF424242),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

// Composable kustom untuk ikon sosial media
@Composable
fun SocialIcon(painterRes: Int, color: Color) {
    Image(
        painter = painterResource(id = painterRes),
        contentDescription = null,
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(color)
            .padding(8.dp),

    )
}

// Preview untuk melihat hasil di Android Studio
@Preview(showBackground = true, device = "id:pixel_4")
@Composable
fun ProfileScreenPreview() {
    Prak3Theme {
        ProfileScreen(
            modifier = Modifier
        )
    }
}