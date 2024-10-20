class Solution {
    int idx = 0;

    private boolean solveHelper(String expression) {
        char oper = expression.charAt(idx);
        idx += 2;

        char ch = expression.charAt(idx);
        boolean flag = false;
        if (ch == 't') {
            flag = true;
            idx++;
        } else if (ch == 'f') {
            flag = false;
            idx++;
        } else {
            flag = solveHelper(expression);
        }

        ch = expression.charAt(idx);
        while (ch != ')') {
            if (ch == ',') {
                ch = expression.charAt(++idx);
                continue;
            }

            boolean c_flg = false;
            if (ch == 't') {
                c_flg = true;
                idx++;
            } else if (ch == 'f') {
                c_flg = false;
                idx++;
            } else {
                c_flg = solveHelper(expression);
            }

            if (oper == '&') {
                flag &= c_flg;
            } else if (oper == '|') {
                flag |= c_flg;
            }

            ch = expression.charAt(idx);
        }
        idx++;
        return oper == '!' ? !flag : flag;
    }

    public boolean parseBoolExpr(String expression) {
        if (expression.length() == 1) {
            return expression.charAt(0) == 't';
        }
        return solveHelper(expression);
    }
}