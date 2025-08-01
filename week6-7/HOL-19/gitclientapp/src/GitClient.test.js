// src/GitClient.test.js
import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios');

describe('Git Client Tests', () => {
  test('should return repository names for techiesyed', async () => {
    const mockRepoData = [
      { name: 'repo-one' },
      { name: 'repo-two' },
      { name: 'repo-three' }
    ];

    axios.get.mockResolvedValue({ data: mockRepoData });

    const repoNames = await GitClient.getRepositories('techiesyed');

    expect(repoNames).toEqual(['repo-one', 'repo-two', 'repo-three']);
    expect(axios.get).toHaveBeenCalledWith('https://api.github.com/users/techiesyed/repos');
  });
});
