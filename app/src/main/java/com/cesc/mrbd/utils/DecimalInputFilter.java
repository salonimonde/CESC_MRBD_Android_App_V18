package com.cesc.mrbd.utils;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecimalInputFilter implements InputFilter {
    public Pattern mPattern;

    public DecimalInputFilter(int digitsBeforeZero,int digitsAfterZero) {
        mPattern=Pattern.compile("[0-9]{0," + (digitsBeforeZero-1) + "}+((\\.[0-9]{0," + (digitsAfterZero-1) + "})?)||(\\.)?");
    }
    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        Matcher matcher=mPattern.matcher(dest);
        if(!matcher.matches())
            return "";
        return null;
    }

}

/*
public class DecimalInputFilter implements TextWatcher {
    private boolean isRunning = false;
    private boolean isDeleting = false;
    private final String mask;

    public DecimalInputFilter(String mask) {
        this.mask = mask;
    }

    public static DecimalInputFilter buildCpf() {
        return new DecimalInputFilter("#.##");
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
        isDeleting = count > after;
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (isRunning || isDeleting) {
            return;
        }
        isRunning = true;

        int editableLength = editable.length();
        if (editableLength < mask.length()) {
            if (mask.charAt(editableLength) != '#') {
                editable.append(mask.charAt(editableLength));
            } else if (mask.charAt(editableLength - 1) != '#') {
                editable.insert(editableLength - 1, mask, editableLength - 1, editableLength);
            }
        }
        isRunning = false;
    }
}
*/
