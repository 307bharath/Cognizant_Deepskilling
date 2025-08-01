import React, { useState } from 'react';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

function App() {
  const [selectedView, setSelectedView] = useState("book");
  const [showCourses, setShowCourses] = useState(true);
  let content;

  // JSX element variable
  if (selectedView === "book") {
    content = <BookDetails />;
  } else if (selectedView === "blog") {
    content = <BlogDetails />;
  }

  return (
    <div style={{ padding: '20px' }}>
      <h1>Blogger App</h1>

      {/*ternary rendering */}
      <button onClick={() => setSelectedView("book")}>Show Book Details</button>
      <button onClick={() => setSelectedView("blog")}>Show Blog Details</button>
      <button onClick={() => setShowCourses(!showCourses)}>
        {showCourses ? "Hide Courses" : "Show Courses"}
      </button>

      <hr />
      {content}

      {/* logical AND (&&) rendering */}
      {showCourses && <CourseDetails />}

    </div>
  );
}

export default App;
