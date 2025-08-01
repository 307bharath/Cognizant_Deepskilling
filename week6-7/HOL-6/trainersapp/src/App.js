import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './Components/Home';
import TrainersList from './Components/TrainerList';
import TrainerDetails from './Components/TrainerDetails';

const App = () => (
  <BrowserRouter>
  <h1>My Acadamey Trainers App</h1>
    <nav>
      <Link to="/">Home</Link> | <Link to="/trainers">Show Trainers</Link>
    </nav>
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/trainers" element={<TrainersList />} />
      <Route path="/trainer/:id" element={<TrainerDetails />} />
    </Routes>
  </BrowserRouter>
);

export default App;
