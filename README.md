# Bean Plant Disease Prediction App

## Overview
This mobile application is designed to predict diseases of bean plants using machine learning powered by TensorFlow Lite (TFLite). It is developed for Android using Android Studio. The app can classify images of bean plants into one of the following categories:

- **Angular Leaf Spot**
- **Bean Rust**
- **Healthy**
- **Leaf Crinkle**
- **Powdery Mildew**
- **Yellow Mosaic**

The app helps farmers and plant enthusiasts identify plant diseases accurately, offering them the possibility to take corrective actions quickly.

## Features
- **Disease Prediction**: The app uses a pre-trained TFLite model to predict the disease affecting the bean plant based on the image provided by the user.
- **User-Friendly UI**: Simple, intuitive design allowing users to upload images directly for disease diagnosis.
- **Real-time Results**: Instant predictions with confidence levels shown for each class.
- **Plant Health Insights**: Information about the predicted disease and its treatment or prevention.

## UI Features
The app has the following user interface elements:
1. **Image Upload Button**: A button to allow users to upload an image of a bean plant leaf. Supported formats include JPG and PNG.
2. **Prediction Result Display**: After uploading an image, the app shows the predicted disease along with the confidence percentage.
3. **Disease Information**: Brief information about the detected disease, including symptoms, causes, and preventive measures.
4. **Retry Option**: Users can take another picture and try again for more accurate predictions.

## How to Use
1. **Install the App**: Download and install the app on your Android device.
2. **Open the App**: Once the app is installed, open it and allow the necessary permissions (camera and storage).
3. **Upload Image**: Tap the "Upload" button to select a picture of the bean plant leaf. Ensure that the leaf is clear and the disease symptoms are visible.
4. **Receive Prediction**: The app will use a TFLite model to classify the image into one of the six classes: "Bean Rust," "Angular Leaf Spot," "Yellow Mosaic," "Powdery Mildew," "Leaf Crinkle," or "Healthy."
5. **View Results**: The disease prediction along with its confidence score will be displayed. Tap the information button to learn more about the disease and treatment.

## TensorFlow Lite Model
This application uses TensorFlow Lite for fast, on-device predictions. The model has been trained on a dataset of bean plant images with labeled diseases and healthy plant images. The model predicts one of the six categories of diseases, which are:

1. **Bean Rust**: A fungal disease that causes reddish-brown pustules on leaves.
2. **Angular Leaf Spot**: A bacterial disease causing angular, water-soaked lesions on leaves.
3. **Yellow Mosaic**: A viral disease leading to yellowing and deformation of the leaves.
4. **Powdery Mildew**: A fungal infection that results in a white, powdery coating on leaves.
5. **Leaf Crinkle**: A virus-caused disease causing crinkled leaves with distorted growth.
6. **Healthy**: No visible disease, the plant is in good condition.

## Requirements
- Android 5.0 or higher.
- Camera and storage permissions enabled.
- Internet access for initial model download (if applicable).

## Dependencies
- **TensorFlow Lite**: For on-device machine learning inference.
- **Android Studio**: For app development.
- **ML Kit**: For image classification integration.

## Future Updates
- Support for more plant diseases.
- Improved model accuracy and efficiency.
- More detailed plant care suggestions based on predicted disease.

## Contact
For any issues or questions, feel free to contact us at azvadenis@gmail.com.

## Download APK
[Link Download App Dekapan (Deteksi Kacang Panjang)](https://drive.google.com/file/d/1L5iCy585scSPnV6Vi13MNnMDXf0REVAO/view?usp=sharing)

## Preview
| Splash Screen        | Home Screen | Predict Screen     |
|-------------------|-------------------|-------------------|
|![Screenshot_20250318_102853](https://github.com/user-attachments/assets/cb71734e-164e-44d7-a761-48b52b01528c) | ![image](https://github.com/user-attachments/assets/ba1fb34b-a125-4cb7-97b0-5cc1f820f624)|![image](https://github.com/user-attachments/assets/6efb8819-3344-44f4-9cc3-c604c9898f32)|

| Result Predict       | List Plant | Detail List Plant |
|-------------------|-------------------|-------------------|
|![image](https://github.com/user-attachments/assets/99f01a40-7641-48c9-915c-1c66459e5c29) | ![image](https://github.com/user-attachments/assets/52727b48-d533-480e-b8da-c4ebd78afb28) |![image](https://github.com/user-attachments/assets/424489c7-c7fc-43d1-8373-470cfe5ce07b)|


