import {Patient} from './patient';
import {ContactReason} from './contactReason';
import {ContactForm} from './contactForm';

export class Contact {
  id: number;
  name: string;
  patient: Patient;
  contactReason: ContactReason;
  contactForm: ContactForm;
}
