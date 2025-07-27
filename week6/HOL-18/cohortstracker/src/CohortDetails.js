// src/CohortDetails.test.js
import React from 'react';
import { mount, shallow } from 'enzyme';
import CohortDetails from './CohortDetails';
import { CohortsData } from './Cohort';

describe('Cohort Details Component', () => {
  
  test('should create the component', () => {
    const wrapper = shallow(<CohortDetails />);
    expect(wrapper.exists()).toBe(true);
  });

  test('should initialize the props', () => {
    const testCohort = CohortsData[0]; // Using first cohort from data
    const wrapper = mount(<CohortDetails cohort={testCohort} />);
    
    expect(wrapper.props().cohort).toEqual(testCohort);
    expect(wrapper.props().cohort.cohortCode).toBe('INTAMD510');
    expect(wrapper.props().cohort.technology).toBe('.NET FSD');
  });

  test('should display cohort code in h3', () => {
    const testCohort = CohortsData[0]; // Using first cohort from data
    const wrapper = mount(<CohortDetails cohort={testCohort} />);
    
    const h3Element = wrapper.find('h3');
    expect(h3Element.exists()).toBe(true);
    expect(h3Element.text()).toBe(testCohort.cohortCode);
    expect(h3Element.text()).toBe('INTAMD510');
  });

  test('should always render same html', () => {
    const testCohort = CohortsData[0]; // Using first cohort from data
    const wrapper = shallow(<CohortDetails cohort={testCohort} />);
    
    expect(wrapper).toMatchSnapshot();
  });

});