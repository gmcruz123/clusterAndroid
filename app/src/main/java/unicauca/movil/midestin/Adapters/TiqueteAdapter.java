
package unicauca.movil.midestin.Adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import unicauca.movil.midestin.R;
import unicauca.movil.midestin.databinding.TemplateTiqueteBinding;
import unicauca.movil.midestin.util.L;
import com.squareup.picasso.Picasso;


public class TiqueteAdapter extends RecyclerView.Adapter<TiqueteAdapter.TiqueteViewHolder>{

    public interface OnTiqueteListener{
        void onTiquete(View v);
    }
    LayoutInflater inflater;
    OnTiqueteListener onTiqueteListener;

    public TiqueteAdapter(LayoutInflater inflater, OnTiqueteListener onTiqueteListener){
        this.onTiqueteListener= onTiqueteListener;
        this.inflater= inflater;
    }

    @Override
    public TiqueteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_tiquete,parent,false);
        TiqueteViewHolder holder = new TiqueteViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(TiqueteViewHolder holder, int position) {
        holder.binding.setTiq(L.data.get(position));
        holder.binding.setHandler(this);
    }

    @Override
    public int getItemCount() {

        return L.data.size();
    }

    public void onClickTiquete (View v){
        onTiqueteListener.onTiquete(v);

    }


//Retorna tipo de variable o celda
 /*   @Override
    public int getItemViewType(int position) {
        return 0;
    }

    */

    public  static class TiqueteViewHolder extends RecyclerView.ViewHolder{
        TemplateTiqueteBinding binding;
        public TiqueteViewHolder(View itemView) {
            super(itemView);

            binding= DataBindingUtil.bind(itemView);

        }
    }
}
