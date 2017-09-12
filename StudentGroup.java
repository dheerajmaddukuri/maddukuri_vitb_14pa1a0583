import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return this.students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		try {
			if(students == null)
				throw new IllegalArgumentException();
		}
		catch(IllegalArgumentException IE)
		{
			System.out.println("An Illegal Argument Exception has occured.");
		}
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		try {
			if((index < 0) || (index >= students.length))
				throw new IllegalArgumentException();
			else
				return students[index];
		}
		catch(IllegalArgumentException ie)
		{
			System.out.println("the Array Inex out of bounds.");
		}
		
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		try {
			if((index < 0) || (index >= students.length) || (student == null))
				throw new IllegalArgumentException();
			else
				students[index] = student;
		}
		catch(IllegalArgumentException ie)
		{
			System.out.println("the Array Inex out of bounds.");
		}
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		try {
			if(student == null)
				throw new IllegalArgumentException();
			else
			{
				Student temp1,temp2;
				temp1 = students[0];
				int i;
				students[0] = student;
				for(i = 1; i < students.length;i++)
				{
					temp2 = students[i];
					students[i] = temp1;
					temp1 = temp2;
					
				}
				students.length += 1;
				students[students.length-1] = temp1;
			}
		}
		catch(IllegalArgumentException ie)
		{
			System.out.println("An Illegal Argument Exception has occured.");
		}
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		try {
			if(student == null)
				throw new IllegalArgumentException();
			else
			{
				students.length += 1;
				students[students.length-1] = student;
			}
		}
		catch(IllegalArgumentException ie)
		{
			System.out.println("An Illegal Argument Exception has occured.");
		}
		
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		try {
			if(student == null)
				throw new IllegalArgumentException();
			else
			{
				Student temp1,temp2;
				temp1 = students[index];
				int i;
				students[index] = student;
				for(i = index+1; i < students.length;i++)
				{
					temp2 = students[i];
					students[i] = temp1;
					temp1 = temp2;
					
				}
				students.length += 1;
				students[students.length-1] = temp1;
			}
		}
		catch(IllegalArgumentException ie)
		{
			System.out.println("An Illegal Argument Exception has occured.");
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		try {
			if((index < 0) || (index >= students.length))
				throw new IllegalArgumentException();
			else
				for(int i = index; i < students.length-1; i++)
				{
					students[i] = students[i+1];
				}
			    students.length -= 1;
		}
		catch(IllegalArgumentException ie)
		{
			System.out.println("the Array Inex out of bounds.");
		}
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		int found = 0;
		try {
			if(student == null)
				throw new IllegalArgumentException();
			else
				for(int i = 0; i < students.length; i++)
				{
					if(student.equals(students[i]))
					{
						found = 1;
						for(i = i; i < students.length; i++)
						{
							students[i] = students[i+1];
						}
					}
					students.length -= 1;
					break;
				}
			    try {
			    	if(found == 0)
			    	{
			    		throw new IllegalArgumentException();
			    	}
			    }
			    catch(IllegalArgumentException ie)
			    {
			    	System.out.println("Student not Exist");
			    }
		}
		catch(IllegalArgumentException ie)
		{
			System.out.println("An Illegal Argument Exception has occured.");
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		try {
			if((index < 0) || (index >= students.length))
				throw new IllegalArgumentException();
			else
			    students.length = index+1;
		}
		catch(IllegalArgumentException ie)
		{
			System.out.println("the Array Inex out of bounds.");
		}
		
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		try {
			if(student == null)
				throw new IllegalArgumentException();
			else
			{
				for(int i = 0; i < students.length; i++)
				{
					if(student.equals(students[i]))
					{
						students.length = i + 1;
					}
					
					break;
				}
			}
		}
		catch(IllegalArgumentException IE)
		{
			System.out.println("An Illegal Argument Exception has occured.");
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		try {
			if((index < 0) || (index >= students.length))
				throw new IllegalArgumentException();
			else
			{
				int i;
				for(i = 0; i < students.length && index < students.length; i++)
				{
					students[i] = students[index];
					index++;
				}
				students.length = i + 1;
			}
		}
		catch(IllegalArgumentException ie)
		{
			System.out.println("An Illegal Argument Exception has occured.");
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		int i,j = 0;
		try {
			if(student == null)
				throw new IllegalArgumentException();
			else
			{
				for(i = 0; i < students.length; i++)
				{
					if(student.equals(students[i]))
					{
						for(j = 0; j < students.length && i < students.length; j++)
						{
							students[j] = students[i];
							i++;
						}
						break;
					}
				}
				students.length = j + 1;
			}
		}
		catch(IllegalArgumentException ie)
		{
			System.out.println("An Illegal Argument Exception has occured.");
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		int i,j,n;
		int comp;
		n = students.length;
		for(i = 0; i < (n-1); i++)
		{
			for(j = i+1; j < (n-1-i); j++)
			{
				comp = students[i].compareTo(students[j]);
				if(comp > 0)
				{
					Student temp;
					temp = students[i];
					students[i] = students[j];
					students[j] = temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		try {
			if(date == null)
				throw new IllegalArgumentException();
		}
		catch(IllegalArgumentException ie)
		{
			System.out.println("An Illegal Argument Exception has occured.");
		}
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		return null;
	}
}
