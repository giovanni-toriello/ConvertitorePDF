package it.unisa.app;

import javax.swing.filechooser.FileFilter;
import java.io.File;


public class FileFilterRecognize extends FileFilter {
    @Override
    public boolean accept(File f) {
        String extension = components.Utils.getExtension(f);
        if(f.isDirectory()){
            return true;
        }
        if(extension == null){
            return false;
        }
        if(extension.equals("docx")) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "File Word (*.docx/doc)";
    }
}
