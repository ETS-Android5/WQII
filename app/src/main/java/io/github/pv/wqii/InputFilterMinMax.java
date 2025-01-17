package io.github.pv.wqii;


import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputFilterMinMax implements InputFilter {

    private float min, max;

    public InputFilterMinMax(float min, float max) {
        this.min = min;
        this.max = max;
    }

    public InputFilterMinMax(String min, String max) {
        this.min = Float.parseFloat(min);
        this.max = Float.parseFloat(max);
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            // Remove the string out of destination that is to be replaced
            String newVal = dest.toString().substring(0, dstart) + dest.toString().substring(dend, dest.toString().length());
            // Add the new string in
            newVal = newVal.substring(0, dstart) + source.toString() + newVal.substring(dstart, newVal.length());
            float input = Float.parseFloat(newVal);
            Pattern mPattern = Pattern.compile("[0-9]{0," + (10 - 1) + "}+((\\.[0-9]{0," + (2 - 1) + "})?)||(\\.)?");

            Matcher matcher = mPattern.matcher(dest);
            if (isInRange(min, max, input) && matcher.matches())
                return null;
        } catch (NumberFormatException nfe) { }
        return "";
    }
    private boolean isInRange(float a, float b, float c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}