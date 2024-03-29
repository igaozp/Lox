package io.github.igaozp.lox;

class AstPrinter implements Expr.Visitor<String> {
    String print(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public String visitAssignExpr(Expr.Assign expr) {
        // todo
        return null;
    }

    @Override
    public String visitBinaryExpr(Expr.Binary expr) {
        return parentTheSize(expr.operator.lexeme, expr.left, expr.right);
    }

    @Override
    public String visitCallExpr(Expr.Call expr) {
        // todo
        return null;
    }

    @Override
    public String visitGroupingExpr(Expr.Grouping expr) {
        return parentTheSize("group", expr.expression);
    }

    @Override
    public String visitLiteralExpr(Expr.Literal expr) {
        if (expr.value == null) {
            return "nil";
        }
        return expr.value.toString();
    }

    @Override
    public String visitLogicalExpr(Expr.Logical expr) {
        // todo
        return null;
    }

    @Override
    public String visitUnaryExpr(Expr.Unary expr) {
        return parentTheSize(expr.operator.lexeme, expr.right);
    }

    @Override
    public String visitVariableExpr(Expr.Variable expr) {
        // todo
        return null;
    }

    @Override
    public String visitGetExpr(Expr.Get expr) {
        // todo
        return null;
    }

    @Override
    public String visitSetExpr(Expr.Set expr) {
        // todo
        return null;
    }

    @Override
    public String visitThisExpr(Expr.This expr) {
        // todo
        return null;
    }

    private String parentTheSize(String name, Expr... exprs) {
        var builder = new StringBuilder();

        builder.append("(").append(name);
        for (Expr expr : exprs) {
            builder.append("  ");
            builder.append(expr.accept(this));
        }
        builder.append(")");

        return builder.toString();
    }

    public static void main(String[] args) {
        var expression = new Expr.Binary(
                new Expr.Unary(
                        new Token(TokenType.MINUS, "-", null, 1),
                        new Expr.Literal(123)
                ),
                new Token(TokenType.STAR, "*", null, 1),
                new Expr.Grouping(
                        new Expr.Literal(45.67)
                )
        );
        System.out.println(new AstPrinter().print(expression));
    }
}
