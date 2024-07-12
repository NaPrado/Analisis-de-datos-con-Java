import querys.Queries;

import java.io.IOException;
import java.time.Year;

public enum QuerysEnum {
    QUERY1{
        @Override
        public void executeQuery(Queries q) throws IOException {
            q.query1();
        }
        @Override
        public void executeQuery(Queries q, Year min) throws IOException {
            executeQuery(q);
        }
        @Override
        public void executeQuery(Queries q, Year min, Year max) throws IOException {
            executeQuery(q);
        }
    },
    QUERY2{
        @Override
        public void executeQuery(Queries q) throws IOException {
            q.query2();
        }
        @Override
        public void executeQuery(Queries q, Year min) throws IOException {
            executeQuery(q);
        }
        @Override
        public void executeQuery(Queries q, Year min, Year max) throws IOException {
            executeQuery(q);
        }
    },
    QUERY3{
        @Override
        public void executeQuery(Queries q) throws IOException {
            q.query3();
        }
        @Override
        public void executeQuery(Queries q, Year min) throws IOException {
            executeQuery(q);
        }
        @Override
        public void executeQuery(Queries q, Year min, Year max) throws IOException {
            executeQuery(q);
        }
    },
    QUERY4{
        @Override
        public void executeQuery(Queries q) throws IOException {
            q.query4();
        }
        @Override
        public void executeQuery(Queries q, Year min) throws IOException {
            q.query4(min);
        }
        @Override
        public void executeQuery(Queries q, Year min, Year max) throws IOException {
            q.query4(min, max);
        }
    },
    QUERY5{
        @Override
        public void executeQuery(Queries q) throws IOException {
            q.query5();
        }
        @Override
        public void executeQuery(Queries q, Year min) throws IOException {
            q.query5(min);
        }
        @Override
        public void executeQuery(Queries q, Year min, Year max) throws IOException {
            q.query5(min, max);
        }
    };
    public abstract void executeQuery(Queries q) throws IOException;
    public abstract void executeQuery(Queries q, Year min) throws IOException;
    public abstract void executeQuery(Queries q, Year min, Year max) throws IOException;
}
