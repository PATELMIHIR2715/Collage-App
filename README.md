# 📸 Collage-App (Android)

An Android application that allows users to create image collages by selecting multiple photos from their device, arranging them, and saving or sharing the final collage. Built using **Java**, **XML**, and **Firebase** for real-time storage and data handling.

## ✨ Features

- 📁 Select multiple images from device storage
- 🖼️ Arrange images in a collage layout
- 📲 Save collage to device or share it directly
- ☁️ Firebase integration (e.g., for user data, image storage)
- 🔐 User authentication (optional, if implemented)

## 🛠️ Tech Stack

- **Java (Android)**
- **XML** for UI layouts
- **Firebase** (Authentication, Realtime Database, Storage)

## 📦 Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/PATELMIHIR2715/Collage-App.git
   ```
2. **Open in Android Studio**
    - Open Android Studio
    - Click on Open an existing project
    - Navigate to the cloned folder
  
3. **Set Up Firebase**
    - Add your google-services.json file in the /app directory
    - Make sure Firebase services (Auth, Realtime DB, Storage) are enabled in your Firebase console
  
4. **Build and Run**
    - Connect an Android device or use an emulator
    - Click ▶️ (Run)

## 📂 Project Structure

  Collage-App/
  
├── app/

│   ├── java/com/yourpackage/

│   │   ├── MainActivity.java

│   │   ├── CollageActivity.java

│   ├── res/

│   │   ├── layout/

│   │   ├── drawable/

│   │   ├── values/

│   ├── AndroidManifest.xml

├── google-services.json (add your own)

├── build.gradle


## 🚀 Future Enhancements
  - Add collage templates (grid, freestyle, heart-shaped, etc.)
  - Drag-and-drop image arrangement
  - Image filters and text overlays
  - Social sharing (Instagram, WhatsApp)
  - Offline support




