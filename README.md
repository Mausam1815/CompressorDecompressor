# CompressorDecompressor

This Java project provides a simple graphical user interface (GUI) for compressing and decompressing files using the GZIP compression algorithm. It utilizes the Java Swing library to create an intuitive interface for users to select and process files.

## Introduction

This project aims to simplify file compression and decompression tasks by offering a user-friendly interface. It includes two main functionalities:

1. **Compress Files:** Users can select a file and compress it using the GZIP compression algorithm. The compressed file will be saved with a `.gz` extension.

2. **Decompress Files:** Users can select a compressed file (with a `.gz` extension) and decompress it, recovering the original file.

## Project Structure

The project is organized into the following packages:

- `GUI`: Contains the main class responsible for creating the GUI and handling user interactions.

- `Compress_Decompress`: Contains two utility classes, `Compressor` and `Decompressor`, which provide methods for compressing and decompressing files, respectively.

## Usage

1. **Compile and Run:** Compile the project using Java and run the `Main` class in the `GUI` package. This will launch the GUI.

2. **Compressing a File:**
   - Click the "Select File to Compress" button.
   - Choose the file you want to compress using the file chooser dialog.
   - The compressed file will be saved in the same directory with a `.gz` extension.

3. **Decompressing a File:**
   - Click the "Select File to Decompress" button.
   - Choose the compressed file (with a `.gz` extension) you want to decompress using the file chooser dialog.
   - The decompressed file will be saved in the same directory without the `.gz` extension.

## Dependencies

This project uses the following libraries:

- Java Swing: For creating the graphical user interface.
- Java GZIP Compression: Utilized in the `Compressor` and `Decompressor` classes for compressing and decompressing files.

No additional dependencies are required.

## Contributing

Contributions to this project are welcome! If you have any ideas for improvements or new features, please feel free to submit issues or pull requests.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Enjoy compressing and decompressing files with ease using this Java Swing-based application! If you encounter any issues or have suggestions for improvements, please don't hesitate to let us know.
