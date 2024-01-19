public class Lesson {
	public int id;
	public String name;
	public double price;
	public double discountedPrice;
	public boolean discountedApplied;
	public String lessonNote;
	
	@Override
	public String toString() {
		return "Lesson [id=" + id + ", name=" + name + ", price=" + price + ", discountedPrice=" + discountedPrice
				+ ", discountedApplied=" + discountedApplied + ", lessonNote=" + lessonNote + "]";
	}
}

////////////////////////////////////////////////////////////////

abstract class LessonBuilder {
	public Lesson lesson;
	
	public abstract void getLesson();
	public abstract void applyDiscount();
	public abstract void addLessonNote();
	public abstract Lesson getResult();
}


class NewStudentLessonBuilder extends LessonBuilder {
	@Override
	public void getLesson() {
		lesson = new Lesson();
		lesson.id = 1;
		lesson.name = "AI Beginner to Advanced";
		lesson.price = 49.99;
	}
	
	@Override
	public void applyDiscount() {
		lesson.discountedPrice = lesson.price * 0.5;
		lesson.discountedApplied = true;
	}
	
	@Override
	public void addLessonNote() {
		lesson.lessonNote = "He, Welcome in your first course";
	}
	
	@Override
	public Lesson getResult() {
		return lesson;
	}
}


class OldStudentLessonBuilder extends LessonBuilder {
	@Override
	public void getLesson() {
		lesson = new Lesson();
		lesson.id = 1;
		lesson.name = "AI Beginner to Advanced";
		lesson.price = 49.99;
	}
	
	@Override
	public void applyDiscount() {
		lesson.discountedPrice = 0;
		lesson.discountedApplied = false;
	}
	
	@Override
	public void addLessonNote() {
		lesson.lessonNote = "";
	}
	
	@Override
	public Lesson getResult() {
		return lesson;
	}
}


//////////////////////////////////////////////////////////////////////

class Director {
	private LessonBuilder lessonBuilder;
	
	public Director(LessonBuilder lessonBuilder) {
		this.lessonBuilder = lessonBuilder;
	}
	
	public void make() {
		lessonBuilder.getLesson();
		lessonBuilder.applyDiscount();
		lessonBuilder.addLessonNote();
	}
}

///////////////////////////////////////////////////////////////

public class Main {

	public static void main(String[] args) {
		LessonBuilder lb = new NewStudentLessonBuilder();
		
		Director ld = new Director(lb);
		
		ld.make();
		
		Lesson lesson = lb.getResult();
		
		System.out.println(lesson);
	}

}