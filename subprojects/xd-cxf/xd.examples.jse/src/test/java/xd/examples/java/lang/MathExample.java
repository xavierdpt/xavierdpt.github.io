package xd.examples.java.lang;

import xd.ExampleUtils;
import xdtest.Scaffolded;

import java.io.IOException;

@Scaffolded
public class MathExample {

    public void scaffold() throws ClassNotFoundException, IOException, InterruptedException {
        if (ExampleUtils.skip()) {
            Math instance = ExampleUtils.makeInstance(Math.class);

            double d = 0;

            double sin = Math.sin(d);

            double cos = Math.cos(d);

            double tan = Math.tan(d);

            double asin = Math.asin(d);
            double acos = Math.acos(d);
            double atan = Math.atan(d);

            double v = Math.toRadians(d);
            double v1 = Math.toDegrees(d);

            double exp = Math.exp(d);
            double log = Math.log(d);
            double v2 = Math.log10(d);

            double sqrt = Math.sqrt(d);
            double cbrt = Math.cbrt(d);

            double v3 = Math.IEEEremainder(d, d);

            double ceil = instance.ceil(d);
            double floor = instance.floor(d);

            double rint = Math.rint(d);

            double v4 = Math.atan2(d, d);

            double pow = Math.pow(d, d);

            float f = 0;
            int round = Math.round(f);

            long round1 = Math.round(d);

            double random = Math.random();


            int i = 0;
            int i1 = Math.addExact(i, i);

            long l = 0;
            long l1 = Math.addExact(l, l);

            int i2 = Math.subtractExact(i, i);
            long l2 = Math.subtractExact(l, l);

            int i3 = Math.multiplyExact(i, i);
            long l3 = Math.multiplyExact(l, i);
            long l4 = Math.multiplyExact(l, l);

            int i4 = Math.divideExact(i, i);
            long l5 = Math.divideExact(l, l);

            int i5 = Math.floorDivExact(i, i);
            long l6 = Math.floorDivExact(l, l);

            int i6 = Math.ceilDivExact(i, i);
            long l7 = Math.ceilDivExact(l, l);

            int i7 = Math.incrementExact(i);
            long l8 = Math.incrementExact(l);

            int i8 = Math.decrementExact(i);
            long l9 = Math.decrementExact(l);

            int i9 = Math.negateExact(i);
            long l10 = Math.negateExact(l);
            int i10 = Math.toIntExact(l);
            long l11 = Math.multiplyFull(i, i);
            long l12 = Math.multiplyHigh(l, l);
            long l13 = Math.unsignedMultiplyHigh(l, l);
            int i11 = Math.floorDiv(i, i);
            long l14 = Math.floorDiv(l, i);
            long l15 = Math.floorDiv(l, l);
            int i12 = Math.floorMod(i, i);
            int i13 = Math.floorMod(l, i);
            long l16 = Math.floorMod(l, l);
            int i14 = Math.ceilDiv(i, i);
            long l17 = Math.ceilDiv(l, i);
            long l18 = Math.ceilDiv(l, l);
            int i15 = Math.ceilMod(i, i);
            int i16 = Math.ceilMod(l, i);
            long l19 = Math.ceilMod(l, l);
            int abs = Math.abs(i);
            int i17 = Math.absExact(i);
            long abs1 = Math.abs(l);
            long l20 = Math.absExact(l);
            float abs2 = Math.abs(f);
            double abs3 = Math.abs(d);
            int max = Math.max(i, i);
            long max1 = Math.max(l, l);
            float max2 = Math.max(f, f);
            double max3 = Math.max(d, d);
            int min = Math.min(i, i);
            long min1 = Math.min(l, l);
            float min2 = Math.min(f, f);
            double min3 = Math.min(d, d);
            double fma = Math.fma(d, d, d);
            float fma1 = Math.fma(f, f, f);
            double ulp = Math.ulp(d);
            float ulp1 = Math.ulp(f);
            double signum = Math.signum(d);
            float signum1 = Math.signum(f);
            double sinh = Math.sinh(d);
            double cosh = Math.cosh(d);
            double tanh = Math.tanh(d);
            double hypot = Math.hypot(d, d);
            double v5 = Math.expm1(d);
            double v6 = Math.log1p(d);
            double v7 = Math.copySign(d, d);
            float v8 = Math.copySign(f, f);
            int exponent = Math.getExponent(f);
            int exponent1 = Math.getExponent(d);
            double v9 = Math.nextAfter(d, d);
            float v10 = Math.nextAfter(f, d);
            double v11 = Math.nextUp(d);
            float v12 = Math.nextUp(f);
            double v13 = Math.nextDown(d);
            float v14 = Math.nextDown(f);
            double scalb = Math.scalb(d, i);
            float scalb1 = Math.scalb(f, i);
            double e = Math.E;
            double pi = Math.PI;


        }
    }

}
