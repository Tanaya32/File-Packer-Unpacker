# 📦 File Packer & Unpacker (Java)

## 📂 Project Structure

```
Projects/
│
├── File_Packer.java
├── File_Unpacker.java
├── cvfs.cpp
├── C++ interview.pdf
├── DBMS interview.pdf
└── other files...
```

---

## 🚀 Features

- Pack multiple `.txt` files into a single file  
- Unpack them back to original files  
- Uses simple XOR encryption (`0x11`)  
- Header-based file storage (name + size)

---

## 🧠 How It Works

### 🔹 Packer
- Takes folder input  
- Reads all `.txt` files  
- Creates 100-byte header (file name + size)  
- Encrypts data using XOR  
- Writes into packed file  

### 🔹 Unpacker
- Reads packed file  
- Extracts header  
- Gets file name & size  
- Decrypts using XOR  
- Recreates original files  

---

## ⚙️ How to Run

### Compile
```
javac File_Packer.java
javac File_Unpacker.java
```

### Run Packer
```
java File_Packer
```

### Run Unpacker
```
java File_Unpacker
```

---

## 🔐 Encryption Logic

```
Buffer[i] = (byte)(Buffer[i] ^ 0x11);
```

---

## 🛠️ Tech Stack

- Java  
- File Handling  
- XOR Encryption  

---

## 👩‍💻 Author

Tanaya G
