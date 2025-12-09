void main() {
    int h1 = 9, m1 = 20;
    int h2 = 10, m2 = 10;

    int totalMinutosDif = Math.abs((60*h1 + m1) - (60*h2 + m2)); // Sacamos el total de minutos de ambos momentos y calculamos la diferencia.
    int hDif = totalMinutosDif / 60;
    int mDif = totalMinutosDif % 60;

    IO.println(String.format("La diferencia horaria será de %d horas y %d minutos.\n", hDif, mDif));

    if (
            (h1 > h2) || (h1 == h2 && m1 > m2)
    ) {
        int hTemp = h1;
        int mTemp = m1;
        h1 = h2;
        m1 = m2;
        h2 = hTemp;
        m2 = mTemp;
    }

    hDif = h2-h1;
    mDif = m2-m1;

    if (mDif < 0) {
        hDif = hDif - 1;
        mDif = mDif + 60;
    }

    IO.println(String.format("La diferencia horaria será de %d horas y %d minutos.\n", hDif, mDif));

    if (h1 < h2) {
        if (m1 < m2) {
            hDif = h2-h1;
            mDif = m2-m1;
        }
        if (m1 == m2) {
            hDif = h2-h1;
            mDif = m2-m1;
        }
        if (m1 > m2) {
        }
    }

    if (h1 == h2) {
        if (m1 < m2) {
        }
        if (m1 == m2) {
        }
        if (m1 > m2) {
        }
    }

    if (h1 > h2) {
        if (m1 < m2) {
        }
        if (m1 == m2) {
        }
        if (m1 > m2) {
        }
    }
    String cadena = String.format("La diferencia horaria será de %d horas y %d minutos.\n", hDif, mDif);
}
