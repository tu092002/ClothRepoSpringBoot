import { Admin, Resource,ListGuesser } from 'react-admin'
import restProvider from 'ra-data-simple-rest'

const dataProvider = restProvider('http://localhost:3000');

function AdminReact() {
    return (
      <Admin dataProvider={dataProvider}>
        <Resource name="users" list={ListGuesser} />
      </Admin>
    );
  }
export default AdminReact;