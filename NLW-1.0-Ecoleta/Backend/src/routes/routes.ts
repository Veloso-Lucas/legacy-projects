import express, { response } from 'express';
import multer from 'multer';
import multerConfig from '../config/multer';
import PointControllers from '../controllers/pointsControllers';
import ItemsControllers from '../controllers/itemsControllers';

const routes = express.Router();
const upload = multer(multerConfig);

const pointControllers = new PointControllers();
const itemsControllers = new ItemsControllers();

routes.get('/items', itemsControllers.index);
routes.get('/points/:id', pointControllers.show);
routes.get('/points', pointControllers.index);

routes.post('/points', 
    upload.single('image'),
    pointControllers.create
);
export default routes;