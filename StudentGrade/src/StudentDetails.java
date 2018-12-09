import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("serial")
public class StudentDetails extends Exception {
	ArrayList<String> Student = new ArrayList<String>(5);
	ArrayList<Character> Grade = new ArrayList<Character>(5);
	ArrayList<ArrayList<Double>> TestScore = new ArrayList<ArrayList<Double>>();

	// constructor
	public StudentDetails() {
	}

	// parameterized constructor
	public StudentDetails(String str) {
		super(str);
	}

	@SuppressWarnings("resource")
	// function to get input from users
	public void getinfo() {

		for (int i = 0; i < 5; i++) {
			Scanner input = new Scanner(System.in);
			System.out.println("enter the name of student");
			Student.add(input.nextLine());

			System.out.println("enter the test score of four subject");

			ArrayList<Double> Score = new ArrayList<Double>(4);
			// try catch statement for catching exception
			try {
				for (int j = 0; j < 4; j++) {
					double score = input.nextDouble();
					Score.add(score);

					// exception is throwed if score is less than 0
					// or greater than 100
					if (score < 0) {
						StudentDetails me = new StudentDetails("Score is less than 0");
						throw me;
					}
					if (score > 100) {
						StudentDetails me = new StudentDetails("Score is greater than 100");
						throw me;
					}
				}
				TestScore.add(Score);
			} catch (StudentDetails e) {
				e.printStackTrace();
				i--;
			}
		}
	}

	// function to return Grade based on average score
	public char AssignGrade(double avgScore) {
		char grade;
		if (avgScore >= 90 && avgScore <= 100) {
			grade = 'A';
		} else if (avgScore >= 80 && avgScore < 90) {
			grade = 'B';
		} else if (avgScore >= 70 && avgScore < 80) {
			grade = 'C';
		} else if (avgScore >= 60 && avgScore < 70) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		return grade;
	}

	// function to calculate and return Average score
	public double Average(int i) {
		double AvgScore = 0;
		ArrayList<Double> Score = TestScore.get(i);
		for (int j = 0; j < 4; j++) {
			AvgScore = AvgScore + Score.get(j);
		}
		return AvgScore / 4.0;
	}

	// function for display Student name ,Average score and grade of respective
	// student
	public void display() {
		for (int i = 0; i < 5; i++) {
			System.out.print(Student.get(i) + " ");
			double Avg = Average(i);
			System.out.print(Avg + " ");
			System.out.print(AssignGrade(Avg) + " ");
			Grade.add(AssignGrade(Avg));
			System.out.println();
		}
	}

	public static void main(String[] arg) {
		// object of StudentDetails class
		StudentDetails Student = new StudentDetails();

		Student.getinfo();
		Student.display();
	}
}
