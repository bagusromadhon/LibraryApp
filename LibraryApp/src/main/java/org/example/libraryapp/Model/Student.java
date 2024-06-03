package org.example.libraryapp.Model;

public class Student {
    private String name;
    private String nim;
    private String fakultas;
    private String programStudi;

    public Student(String name, String nim, String fakultas, String programStudi) {
        this.name = name;
        this.nim = nim;
        this.fakultas = fakultas;
        this.programStudi = programStudi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public void setProgramStudi(String programStudi) {
        this.programStudi = programStudi;
    }
}
