import {Patient} from './patient';
import {ContactReason} from './contactReason';
import {ContactForm} from './contactForm';
import {MedicalCarer} from './MedicalCarer';

export class MedicalCarerPatient {
  id: number;
  name: string;
  patient: Patient;
  medicalCarer: MedicalCarer;
}
