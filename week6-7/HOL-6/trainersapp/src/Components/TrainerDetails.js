import { useParams } from 'react-router-dom';
import trainers from './TrainersMock';

const TrainerDetails = () => {
  const { id } = useParams();
  const trainer = trainers.find(t => t.TrainerId === parseInt(id));

  if (!trainer) return <p>Trainer not found</p>;

  return (
    <div>
      <h1>Trainers Details</h1>
      <p><b>{trainer.Name} ({trainer.Technology})</b></p>
      <p> {trainer.Email}</p>
      <p> {trainer.Phone}</p>
      <ul style={{ margin: 0, paddingLeft: '30px' }}>
      {trainer.Skills.map((skill, index) => (
        <li key={index}>{skill}</li>
      ))}
    </ul>
    </div>
  );
};

export default TrainerDetails;
