package com.example.cumpleonboard;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Calendar;

public class onBoard4Fragment extends Fragment {

    private TextView fechaNacimiento;

    public onBoard4Fragment() {
        // Constructor público requerido (vacío)
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflamos el layout para este fragmento
        return inflater.inflate(R.layout.fragment_on_board4, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializamos el TextView
        fechaNacimiento = view.findViewById(R.id.fechaNacimiento);

        // Creamos el Listener para el DatePicker
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // Actualizamos el TextView con la fecha seleccionada
                fechaNacimiento.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        };

        // Configuramos el OnClickListener en el TextView para mostrar el DatePickerDialog
        fechaNacimiento.setOnClickListener(v -> {
            // Obtenemos la fecha actual
            Calendar calendario = Calendar.getInstance();
            int year = calendario.get(Calendar.YEAR);
            int month = calendario.get(Calendar.MONTH);
            int day = calendario.get(Calendar.DAY_OF_MONTH);

            // Mostramos el DatePickerDialog
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    getActivity(), dateSetListener, year, month, day);
            datePickerDialog.show();
        });
    }
}
