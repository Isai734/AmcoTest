package com.amco.tv.model.storage;

import com.amco.tv.model.cast.Cast;
import com.amco.tv.model.program.Program;
import com.amco.tv.model.programs.Programs;

import java.util.List;

/**
 * Clase que almacena datos persistentes.
 */

public class DataSession {

    private final static String TAG = DataSession.class.getSimpleName();
    private static DataSession ourInstance = null;

    private List<Programs> programs;
    private Program program;
    private List<Cast> casts;

    public static DataSession getInstance() {
        if (ourInstance == null)
            ourInstance = new DataSession();
        return ourInstance;
    }

    public List<Programs> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Programs> programs) {
        this.programs = programs;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public List<Cast> getCasts() {
        return casts;
    }

    public void setCasts(List<Cast> casts) {
        this.casts = casts;
    }
}
