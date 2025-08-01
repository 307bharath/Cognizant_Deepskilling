function CourseDetails() {
  const courses = [
    { id: 1, name: "React Fundamentals", duration: "2 weeks" },
    { id: 2, name: "Advanced React Patterns", duration: "3 weeks" },
    { id: 3, name: "Fullstack Architecture", duration: "4 weeks" }
  ];

  return (
    <div>
      <h2>Course Details</h2>
      <ul>
        {courses.map(course => (
          <li key={course.id}>
            {course.name} - {course.duration}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CourseDetails;
