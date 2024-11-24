package Hw6_23001908_VuQuangNam.ex12345;

public class Edge<V> {
    private int w; //trong so
    private Vertex<V> u;
    private Vertex<V> v;
    boolean isDirectional; //true = co huong, false = vo huong

    public Edge(Vertex<V> u, Vertex<V> v, int w, boolean isDirectional) {
        this.u = u;
        this.v = v;
        this.w = w;
        this.isDirectional = isDirectional;
    }

    public int getWeight() {
        return this.w;
    }

    public Vertex<V> getU() {
        return this.u;
    }

    public Vertex<V> getV() {
        return this.v;
    }

    public boolean isDirectional() {
        return isDirectional;
    }

    public boolean equals(Edge<V> e2) {
        if (this.isDirectional) {
            return this.u.equals(e2.u) && this.v.equals(e2.v) && (e2.isDirectional == this.isDirectional);
        }
        return (this.u.equals(e2.u) && this.v.equals(e2.v)) || (this.u.equals(e2.v) && this.v.equals(e2.u));
    }

    @Override
    public String toString() {
        if (isDirectional) {
            return "Edge[" +
                    "w=" + w +
                    ", u=" + u +
                    ", v=" + v +
                    ", isDirectional=" + isDirectional +
                    ']';
        }
        return "[" +
                "w=" + w +
                ", u=" + u +
                ", v=" + v +
                ']';
    }
}

