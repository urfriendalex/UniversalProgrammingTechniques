package UTP1;

public class Student implements IAggregable<Student, String>, IDeeplyCloneable<Student> {
        private String name;
        private String surname;
        private  String sNum;

        public Student() {

        }

        public Student(String name,String surname,String sNum)  {
           this.name=name;
           this.sNum=sNum;
           this.surname=surname;
        }

        public String name() {
            return name;
        }
        public String sNum(){
            return sNum;
        }
        public String surname(){
            return surname;
        }
        @Override
        public String aggregate(String intermediateResult) {
            if  (intermediateResult == null) {
                return surname+" "+name+" "+sNum.replaceAll("\\D+","")+"\n";
            }
            else
                return  intermediateResult+surname+" "+name+" "+sNum.replaceAll("\\D+","")+"\n";
        }

        @Override
        public Student deepClone() {
            Student clone = new Student();
            clone.surname = surname;
            clone.name = name;
            clone.sNum = sNum;
            return clone;
        }

    }
