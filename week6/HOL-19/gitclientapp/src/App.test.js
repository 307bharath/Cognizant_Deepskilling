import { render, screen } from '@testing-library/react';
import App from './App';

test('renders Git Repositories heading', () => {
  render(<App />);
  const headingElement = screen.getByText(/Git Repositories of user/i);
  expect(headingElement).toBeInTheDocument();
});
